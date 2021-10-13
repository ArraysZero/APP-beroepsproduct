package nl.han.ica.icss.parser;

import java.beans.Expression;
import java.util.Stack;


import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
import nl.han.ica.icss.ast.operations.DivideOperation;
import nl.han.ica.icss.ast.operations.MultiplyOperation;
import nl.han.ica.icss.ast.operations.SubtractOperation;
import nl.han.ica.icss.ast.selectors.ClassSelector;
import nl.han.ica.icss.ast.selectors.IdSelector;
import nl.han.ica.icss.ast.selectors.TagSelector;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class extracts the ICSS Abstract Syntax Tree from the Antlr Parse tree.
 */
public class ASTListener extends ICSSBaseListener {
	
	//Accumulator attributes:
	private AST ast;

	//Use this to keep track of the parent nodes when recursively traversing the ast
	private IHANStack<ASTNode> currentContainer;

	public ASTListener() {
		ast = new AST();
		currentContainer = new HANStack<>();
	}

    public AST getAST() {
        return ast;
    }

	@Override
	public void enterStylesheet(ICSSParser.StylesheetContext ctx) {
		ASTNode stylesheet = new Stylesheet();
		currentContainer.push(stylesheet);
	}

	@Override
	public void exitStylesheet(ICSSParser.StylesheetContext ctx) {
		ast.setRoot((Stylesheet) currentContainer.pop());
	}

	@Override
	public void enterStylerule(ICSSParser.StyleruleContext ctx) {
		ASTNode stylerule = new Stylerule();
		currentContainer.push(stylerule);
	}

	@Override
	public void exitStylerule(ICSSParser.StyleruleContext ctx) {
		ASTNode stylerule = currentContainer.pop();
		currentContainer.peek().addChild(stylerule);
	}

	@Override
	public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
		ASTNode declaration = new Declaration();
		currentContainer.push(declaration);
	}

	@Override
	public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
		ASTNode declaration = currentContainer.pop();
		currentContainer.peek().addChild(declaration);
	}

	@Override
	public void enterProperty(ICSSParser.PropertyContext ctx) {
		ASTNode property = new PropertyName(ctx.getText());
		currentContainer.push(property);
	}

	@Override
	public void exitProperty(ICSSParser.PropertyContext ctx) {
		ASTNode property = currentContainer.pop();
		currentContainer.peek().addChild(property);
	}

	@Override
	public void enterVariableassignment(ICSSParser.VariableassignmentContext ctx) {
		ASTNode assignment = new VariableAssignment();
		currentContainer.push(assignment);
	}

	@Override
	public void exitVariableassignment(ICSSParser.VariableassignmentContext ctx) {
		ASTNode assignment = currentContainer.pop();
		currentContainer.peek().addChild(assignment);
	}

	@Override
	public void enterIfclause(ICSSParser.IfclauseContext ctx) {
		super.enterIfclause(ctx);
	}

	@Override
	public void exitIfclause(ICSSParser.IfclauseContext ctx) {
		super.exitIfclause(ctx);
	}

	@Override
	public void enterElseclause(ICSSParser.ElseclauseContext ctx) {
		super.enterElseclause(ctx);
	}

	@Override
	public void exitElseclause(ICSSParser.ElseclauseContext ctx) {
		super.exitElseclause(ctx);
	}

	@Override
	public void enterExpression(ICSSParser.ExpressionContext ctx) {
		if(ctx.getChildCount() == 3){
			Operation operation;
			switch (ctx.getChild(1).getText()){
				case "*":
					operation = new MultiplyOperation();
					break;
				case "/":
					operation = new DivideOperation();
					break;
				case "+":
					operation = new AddOperation();
					break;
				default:
					operation = new SubtractOperation();
			}
			currentContainer.push(operation);
		}
	}

	@Override
	public void exitExpression(ICSSParser.ExpressionContext ctx) {
		if (expressionHasTerminalNode(ctx)) {
			ASTNode operation = currentContainer.pop();
			currentContainer.peek().addChild(operation);
		}
	}

	@Override
	public void enterBoolliteral(ICSSParser.BoolliteralContext ctx) {
		ASTNode bool = new BoolLiteral(ctx.getText());
		currentContainer.push(bool);
	}

	@Override
	public void exitBoolliteral(ICSSParser.BoolliteralContext ctx) {
		ASTNode bool = currentContainer.pop();
		currentContainer.peek().addChild(bool);
	}

	@Override
	public void enterColorliteral(ICSSParser.ColorliteralContext ctx) {
		ASTNode color = new ColorLiteral(ctx.getText());
		currentContainer.push(color);
	}

	@Override
	public void exitColorliteral(ICSSParser.ColorliteralContext ctx) {
		ASTNode color = currentContainer.pop();
		currentContainer.peek().addChild(color);
	}

	@Override
	public void enterPercentageliteral(ICSSParser.PercentageliteralContext ctx) {
		super.enterPercentageliteral(ctx);
	}

	@Override
	public void exitPercentageliteral(ICSSParser.PercentageliteralContext ctx) {
		super.exitPercentageliteral(ctx);
	}

	@Override
	public void enterPixelliteral(ICSSParser.PixelliteralContext ctx) {
		ASTNode pixel = new PixelLiteral(ctx.getText());
		currentContainer.push(pixel);
	}

	@Override
	public void exitPixelliteral(ICSSParser.PixelliteralContext ctx) {
		ASTNode pixel = currentContainer.pop();
		currentContainer.peek().addChild(pixel);
	}

	@Override
	public void enterScalarliteral(ICSSParser.ScalarliteralContext ctx) {
		ASTNode scalar = new ScalarLiteral(ctx.getText());
		currentContainer.push(scalar);
	}

	@Override
	public void exitScalarliteral(ICSSParser.ScalarliteralContext ctx) {
		ASTNode scalar = currentContainer.pop();
		currentContainer.peek().addChild(scalar);
	}

	@Override
	public void enterVariable(ICSSParser.VariableContext ctx) {
		ASTNode var = new VariableReference(ctx.getText());
		currentContainer.push(var);
	}

	@Override
	public void exitVariable(ICSSParser.VariableContext ctx) {
		ASTNode var = currentContainer.pop();
		currentContainer.peek().addChild(var);
	}

	@Override
	public void enterLiteral(ICSSParser.LiteralContext ctx) {
		super.enterLiteral(ctx);
	}

	@Override
	public void exitLiteral(ICSSParser.LiteralContext ctx) {
		super.exitLiteral(ctx);
	}

	@Override
	public void enterClassselector(ICSSParser.ClassselectorContext ctx) {
		ASTNode classselect = new ClassSelector(ctx.getText());
		currentContainer.push(classselect);
	}

	@Override
	public void exitClassselector(ICSSParser.ClassselectorContext ctx) {
		ASTNode classselect = currentContainer.pop();
		currentContainer.peek().addChild(classselect);
	}

	@Override
	public void enterTagselector(ICSSParser.TagselectorContext ctx) {
		ASTNode tag = new TagSelector(ctx.getText());
		currentContainer.push(tag);
	}

	@Override
	public void exitTagselector(ICSSParser.TagselectorContext ctx) {
		ASTNode tag = currentContainer.pop();
		currentContainer.peek().addChild(tag);
	}

	@Override
	public void enterIdselector(ICSSParser.IdselectorContext ctx) {
		ASTNode id = new IdSelector(ctx.getText());
		currentContainer.push(id);
	}

	@Override
	public void exitIdselector(ICSSParser.IdselectorContext ctx) {
		ASTNode id = currentContainer.pop();
		currentContainer.peek().addChild(id);
	}

	@Override
	public void enterBody(ICSSParser.BodyContext ctx) {
		super.enterBody(ctx);
	}

	@Override
	public void exitBody(ICSSParser.BodyContext ctx) {
		super.exitBody(ctx);
	}

	@Override
	public void enterEveryRule(ParserRuleContext ctx) {
		super.enterEveryRule(ctx);
	}

	@Override
	public void exitEveryRule(ParserRuleContext ctx) {
		super.exitEveryRule(ctx);
	}

	private boolean expressionHasTerminalNode(ICSSParser.ExpressionContext ctx) {
		return ctx.PLUS() != null || ctx.MIN() != null || ctx.MUL() != null || ctx.DIV() != null;
	}
}