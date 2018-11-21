// Generated from de\lab4inf\wrb\WRB.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link WRBParser#exprAdd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAdd(WRBParser.ExprAddContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#exprSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSub(WRBParser.ExprSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(WRBParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#termMul}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermMul(WRBParser.TermMulContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#termDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermDiv(WRBParser.TermDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(WRBParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#pow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPow(WRBParser.PowContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#signedAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignedAtom(WRBParser.SignedAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(WRBParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(WRBParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#min}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(WRBParser.MinContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#max}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMax(WRBParser.MaxContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#assignFunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignFunc(WRBParser.AssignFuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(WRBParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#userFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserFunction(WRBParser.UserFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#assignVar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVar(WRBParser.AssignVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#matrixMult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrixMult(WRBParser.MatrixMultContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#assignMatrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignMatrix(WRBParser.AssignMatrixContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#vector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVector(WRBParser.VectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link WRBParser#matrix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix(WRBParser.MatrixContext ctx);
}