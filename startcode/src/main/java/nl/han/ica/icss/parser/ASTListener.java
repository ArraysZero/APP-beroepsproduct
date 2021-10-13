package nl.han.ica.icss.parser;

import java.beans.Expression;
import java.util.Stack;


import nl.han.ica.datastructures.HANStack;
import nl.han.ica.datastructures.IHANStack;
import nl.han.ica.icss.ast.*;
import nl.han.ica.icss.ast.literals.*;
import nl.han.ica.icss.ast.operations.AddOperation;
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

		//TODO: uitlezen antlr tree


		//TODO: alle nodes vervolgens in AST plaatsen
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
		ASTNode styleRule = new Stylerule();
		currentContainer.push(styleRule);
	}

	@Override
	public void exitStylerule(ICSSParser.StyleruleContext ctx) {
		super.exitStylerule(ctx);
	}

	@Override
	public void enterDeclaration(ICSSParser.DeclarationContext ctx) {
		ASTNode declaration = new Declaration();
		currentContainer.push(declaration);
	}

	@Override
	public void exitDeclaration(ICSSParser.DeclarationContext ctx) {
		super.exitDeclaration(ctx);
	}

	@Override
	public void enterProperty(ICSSParser.PropertyContext ctx) {
		ASTNode property = new PropertyName();
		currentContainer.push(property);
	}

	@Override
	public void exitProperty(ICSSParser.PropertyContext ctx) {
		super.exitProperty(ctx);
	}

	@Override
	public void enterVariableassignment(ICSSParser.VariableassignmentContext ctx) {
		ASTNode assignment = new VariableAssignment();
		currentContainer.push(assignment);
	}

	@Override
	public void exitVariableassignment(ICSSParser.VariableassignmentContext ctx) {
		super.exitVariableassignment(ctx);
	}

	@Override
	public void enterIfclause(ICSSParser.IfclauseContext ctx) {
		ASTNode clause = new IfClause();
		currentContainer.push(clause);
	}

	@Override
	public void exitIfclause(ICSSParser.IfclauseContext ctx) {
		super.exitIfclause(ctx);
	}

	@Override
	public void enterElseclause(ICSSParser.ElseclauseContext ctx) {
		ASTNode clause = new ElseClause();
		currentContainer.push(clause);
	}

	@Override
	public void exitElseclause(ICSSParser.ElseclauseContext ctx) {
		super.exitElseclause(ctx);
	}

	@Override
	public void enterExpression(ICSSParser.ExpressionContext ctx) {
		if (ctx.getChildCount() == 3) {
			Operation operation;
			switch (ctx.getChild(1).getText()) {
				case "*":
					operation = new MultiplyOperation();
					break;
				case "+":
					operation = new AddOperation();
					break;
				case "/":
					operation = new DivideOperation();
					break;
				default:
					operation = new SubtractOperation();
			}
			currentContainer.push(operation);
	}

	@Override
	public void exitExpression(ICSSParser.ExpressionContext ctx) {
		super.exitExpression(ctx);
	}

	@Override
	public void enterBoolliteral(ICSSParser.BoolliteralContext ctx) {
		//ASTNode bool = new BoolLiteral();
		//currentContainer.push(bool);
	}

	@Override
	public void exitBoolliteral(ICSSParser.BoolliteralContext ctx) {
		super.exitBoolliteral(ctx);
	}

	@Override
	public void enterColorliteral(ICSSParser.ColorliteralContext ctx) {
		super.enterColorliteral(ctx);
	}

	@Override
	public void exitColorliteral(ICSSParser.ColorliteralContext ctx) {
		super.exitColorliteral(ctx);
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
		super.enterPixelliteral(ctx);
	}

	@Override
	public void exitPixelliteral(ICSSParser.PixelliteralContext ctx) {
		super.exitPixelliteral(ctx);
	}

	@Override
	public void enterScalarliteral(ICSSParser.ScalarliteralContext ctx) {
		super.enterScalarliteral(ctx);
	}

	@Override
	public void exitScalarliteral(ICSSParser.ScalarliteralContext ctx) {
		super.exitScalarliteral(ctx);
	}

	@Override
	public void enterVariable(ICSSParser.VariableContext ctx) {
		ASTNode var = new VariableReference();
		currentContainer.push(var);
	}

	@Override
	public void exitVariable(ICSSParser.VariableContext ctx) {
		super.exitVariable(ctx);
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
		super.enterClassselector(ctx);
	}

	@Override
	public void exitClassselector(ICSSParser.ClassselectorContext ctx) {
		super.exitClassselector(ctx);
	}

	@Override
	public void enterTagselector(ICSSParser.TagselectorContext ctx) {
		super.enterTagselector(ctx);
	}

	@Override
	public void exitTagselector(ICSSParser.TagselectorContext ctx) {
		super.exitTagselector(ctx);
	}

	@Override
	public void enterIdselector(ICSSParser.IdselectorContext ctx) {
		super.enterIdselector(ctx);
	}

	@Override
	public void exitIdselector(ICSSParser.IdselectorContext ctx) {
		super.exitIdselector(ctx);
	}

	@Override
	public void enterSelector(ICSSParser.SelectorContext ctx) {
		super.enterSelector(ctx);
	}

	@Override
	public void exitSelector(ICSSParser.SelectorContext ctx) {
		super.exitSelector(ctx);
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

	@Override
	public void visitTerminal(TerminalNode node) {
		super.visitTerminal(node);
	}

	@Override
	public void visitErrorNode(ErrorNode node) {
		super.visitErrorNode(node);
	}
}