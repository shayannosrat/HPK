// Generated from de\lab4inf\wrb\WRB.g4 by ANTLR 4.7
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
	 * Enter a parse tree produced by {@link WRBParser#exprAdd}.
	 * @param ctx the parse tree
	 */
	void enterExprAdd(WRBParser.ExprAddContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#exprAdd}.
	 * @param ctx the parse tree
	 */
	void exitExprAdd(WRBParser.ExprAddContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#exprSub}.
	 * @param ctx the parse tree
	 */
	void enterExprSub(WRBParser.ExprSubContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#exprSub}.
	 * @param ctx the parse tree
	 */
	void exitExprSub(WRBParser.ExprSubContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(WRBParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(WRBParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#termMul}.
	 * @param ctx the parse tree
	 */
	void enterTermMul(WRBParser.TermMulContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#termMul}.
	 * @param ctx the parse tree
	 */
	void exitTermMul(WRBParser.TermMulContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#termDiv}.
	 * @param ctx the parse tree
	 */
	void enterTermDiv(WRBParser.TermDivContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#termDiv}.
	 * @param ctx the parse tree
	 */
	void exitTermDiv(WRBParser.TermDivContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(WRBParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(WRBParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#pow}.
	 * @param ctx the parse tree
	 */
	void enterPow(WRBParser.PowContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#pow}.
	 * @param ctx the parse tree
	 */
	void exitPow(WRBParser.PowContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void enterSignedAtom(WRBParser.SignedAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#signedAtom}.
	 * @param ctx the parse tree
	 */
	void exitSignedAtom(WRBParser.SignedAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(WRBParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(WRBParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(WRBParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(WRBParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#min}.
	 * @param ctx the parse tree
	 */
	void enterMin(WRBParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#min}.
	 * @param ctx the parse tree
	 */
	void exitMin(WRBParser.MinContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#max}.
	 * @param ctx the parse tree
	 */
	void enterMax(WRBParser.MaxContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#max}.
	 * @param ctx the parse tree
	 */
	void exitMax(WRBParser.MaxContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#assignFunc}.
	 * @param ctx the parse tree
	 */
	void enterAssignFunc(WRBParser.AssignFuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#assignFunc}.
	 * @param ctx the parse tree
	 */
	void exitAssignFunc(WRBParser.AssignFuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(WRBParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(WRBParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#userFunction}.
	 * @param ctx the parse tree
	 */
	void enterUserFunction(WRBParser.UserFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#userFunction}.
	 * @param ctx the parse tree
	 */
	void exitUserFunction(WRBParser.UserFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#assignVar}.
	 * @param ctx the parse tree
	 */
	void enterAssignVar(WRBParser.AssignVarContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#assignVar}.
	 * @param ctx the parse tree
	 */
	void exitAssignVar(WRBParser.AssignVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#matrixMult}.
	 * @param ctx the parse tree
	 */
	void enterMatrixMult(WRBParser.MatrixMultContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#matrixMult}.
	 * @param ctx the parse tree
	 */
	void exitMatrixMult(WRBParser.MatrixMultContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#assignMatrix}.
	 * @param ctx the parse tree
	 */
	void enterAssignMatrix(WRBParser.AssignMatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#assignMatrix}.
	 * @param ctx the parse tree
	 */
	void exitAssignMatrix(WRBParser.AssignMatrixContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#vector}.
	 * @param ctx the parse tree
	 */
	void enterVector(WRBParser.VectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#vector}.
	 * @param ctx the parse tree
	 */
	void exitVector(WRBParser.VectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link WRBParser#matrix}.
	 * @param ctx the parse tree
	 */
	void enterMatrix(WRBParser.MatrixContext ctx);
	/**
	 * Exit a parse tree produced by {@link WRBParser#matrix}.
	 * @param ctx the parse tree
	 */
	void exitMatrix(WRBParser.MatrixContext ctx);
}