// Generated from C:/Users/danib/Documents/GitHub/school/ASD/APP/beroepsproduct/startcode/src/main/antlr4/nl/han/ica/icss/parser\ICSS.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ICSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ICSSVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(ICSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#stylerule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylerule(ICSSParser.StyleruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(ICSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(ICSSParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variableassignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableassignment(ICSSParser.VariableassignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#ifclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfclause(ICSSParser.IfclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#elseclause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseclause(ICSSParser.ElseclauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ICSSParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#boolliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolliteral(ICSSParser.BoolliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#colorliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColorliteral(ICSSParser.ColorliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#percentageliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPercentageliteral(ICSSParser.PercentageliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#pixelliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPixelliteral(ICSSParser.PixelliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#scalarliteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScalarliteral(ICSSParser.ScalarliteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(ICSSParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ICSSParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#classselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassselector(ICSSParser.ClassselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#tagselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagselector(ICSSParser.TagselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#idselector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdselector(ICSSParser.IdselectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(ICSSParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ICSSParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(ICSSParser.BodyContext ctx);
}