package de.lab4inf.wrb;

public class WRBObserver extends WRBBaseVisitor<Double> {
	@Override
	public Double visitExpr(WRBParser.ExprContext ctx) {
		return Double.valueOf(ctx.value);
	}
	
	@Override
	public Double visitStatement(WRBParser.StatementContext ctx) {
		return Double.valueOf(ctx.v);
	}
	
	@Override
	public Double visitRun(WRBParser.RunContext ctx) {
		return Double.valueOf(ctx.v);
	}
}
