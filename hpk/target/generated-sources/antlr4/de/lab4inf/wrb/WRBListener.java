// Generated from WRB.g4 by ANTLR 4.4
package de.lab4inf.wrb;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WRBParser}.
 */
public interface WRBListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WRBParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(@NotNull WRBParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(@NotNull WRBParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(@NotNull WRBParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(@NotNull WRBParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull WRBParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull WRBParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull WRBParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull WRBParser.AssignContext ctx);
}