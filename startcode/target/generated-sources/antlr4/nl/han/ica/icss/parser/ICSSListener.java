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
	 * Enter a parse tree produced by {@link ICSSParser#variableassignment}.
	 * @param ctx the parse tree
	 */
	void enterVariableassignment(ICSSParser.VariableassignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#variableassignment}.
	 * @param ctx the parse tree
	 */
	void exitVariableassignment(ICSSParser.VariableassignmentContext ctx);
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
	 * Enter a parse tree produced by {@link ICSSParser#elseclause}.
	 * @param ctx the parse tree
	 */
	void enterElseclause(ICSSParser.ElseclauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#elseclause}.
	 * @param ctx the parse tree
	 */
	void exitElseclause(ICSSParser.ElseclauseContext ctx);
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
	 * Enter a parse tree produced by {@link ICSSParser#boolliteral}.
	 * @param ctx the parse tree
	 */
	void enterBoolliteral(ICSSParser.BoolliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#boolliteral}.
	 * @param ctx the parse tree
	 */
	void exitBoolliteral(ICSSParser.BoolliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#colorliteral}.
	 * @param ctx the parse tree
	 */
	void enterColorliteral(ICSSParser.ColorliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#colorliteral}.
	 * @param ctx the parse tree
	 */
	void exitColorliteral(ICSSParser.ColorliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#percentageliteral}.
	 * @param ctx the parse tree
	 */
	void enterPercentageliteral(ICSSParser.PercentageliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#percentageliteral}.
	 * @param ctx the parse tree
	 */
	void exitPercentageliteral(ICSSParser.PercentageliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#pixelliteral}.
	 * @param ctx the parse tree
	 */
	void enterPixelliteral(ICSSParser.PixelliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#pixelliteral}.
	 * @param ctx the parse tree
	 */
	void exitPixelliteral(ICSSParser.PixelliteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#scalarliteral}.
	 * @param ctx the parse tree
	 */
	void enterScalarliteral(ICSSParser.ScalarliteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#scalarliteral}.
	 * @param ctx the parse tree
	 */
	void exitScalarliteral(ICSSParser.ScalarliteralContext ctx);
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
	 * Enter a parse tree produced by {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ICSSParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ICSSParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 */
	void enterClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 */
	void exitClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 */
	void enterTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 */
	void exitTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 */
	void enterIdselector(ICSSParser.IdselectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 */
	void exitIdselector(ICSSParser.IdselectorContext ctx);
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
	 * Enter a parse tree produced by {@link ICSSParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(ICSSParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link ICSSParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(ICSSParser.BodyContext ctx);
}