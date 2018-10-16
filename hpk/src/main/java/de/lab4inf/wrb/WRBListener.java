// Generated from de/lab4inf/wrb/WRB.g4 by ANTLR 4.7
package de.lab4inf.wrb;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WRBParser}.
 */
public interface WRBListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WRBParser#run}.
	 * @param ctx the parse tree
	 */
	void enterRun(WRBParser.RunContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#run}.
	 * @param ctx the parse tree
	 */
	void exitRun(WRBParser.RunContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(WRBParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(WRBParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(WRBParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(WRBParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#assign}.
	 * @param ctx the parse tree
	 */
	void enterAssign(WRBParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#assign}.
	 * @param ctx the parse tree
	 */
	void exitAssign(WRBParser.AssignContext ctx);
}