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
		ASTNode property = new PropertyName();
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
		ASTNode clause = new IfClause();
		currentContainer.push(clause);
	}

	@Override
	public void exitIfclause(ICSSParser.IfclauseContext ctx) {
		ASTNode clause = currentContainer.pop();
		currentContainer.peek().addChild(clause);
	}

	@Override
	public void enterElseclause(ICSSParser.ElseclauseContext ctx) {
		ASTNode clause = new ElseClause();
		currentContainer.push(clause);
	}

	@Override
	public void exitElseclause(ICSSParser.ElseclauseContext ctx) {
		ASTNode clause = currentContainer.pop();
		currentContainer.peek().addChild(clause);
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
	}

	@Override
	public void exitExpression(ICSSParser.ExpressionContext ctx) {
		if (expressionHasTerminalNode(ctx)) {
			ASTNode operation = currentContainer.pop();
			currentContainer.peek().addChild(operation);
		}
	}

	private boolean expressionHasTerminalNode(ICSSParser.ExpressionContext ctx) {
		return ctx.PLUS() != null || ctx.MIN() != null || ctx.MUL() != null || ctx.DIV() != null;
	}
}