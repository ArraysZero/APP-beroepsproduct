// Generated from nl\han\ica\icss\parser\ICSS.g4 by ANTLR 4.9.1
package nl.han.ica.icss.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ICSSParser}.
 */
public interface ICSSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 */
	void enterStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 */
	void exitStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(ICSSParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(ICSSParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(ICSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(ICSSParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(ICSSParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(ICSSParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#ifclause}.
	 * @param ctx the parse tree
	 */
	void enterIfclause(ICSSParser.IfclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#ifclause}.
	 * @param ctx the parse tree
	 */
	void exitIfclause(ICSSParser.IfclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#ifelseclause}.
	 * @param ctx the parse tree
	 */
	void enterIfelseclause(ICSSParser.IfelseclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#ifelseclause}.
	 * @param ctx the parse tree
	 */
	void exitIfelseclause(ICSSParser.IfelseclauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ICSSParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ICSSParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ICSSParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ICSSParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#comparisonoperation}.
	 * @param ctx the parse tree
	 */
	void enterComparisonoperation(ICSSParser.ComparisonoperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#comparisonoperation}.
	 * @param ctx the parse tree
	 */
	void exitComparisonoperation(ICSSParser.ComparisonoperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(ICSSParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(ICSSParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#variableassignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableassignment(ICSSParser.VariableassignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#variableassignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableassignment(ICSSParser.VariableassignmentContext ctx);
}