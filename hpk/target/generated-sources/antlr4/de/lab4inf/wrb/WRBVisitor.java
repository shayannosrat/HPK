// Generated from de/lab4inf/wrb/WRB.g4 by ANTLR 4.7
package de.lab4inf.wrb;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WRBParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WRBVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WRBParser#run}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRun(WRBParser.RunContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(WRBParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(WRBParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#assign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(WRBParser.AssignContext ctx);
}