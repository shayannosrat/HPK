package de.lab4inf.wrb;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

import de.lab4inf.wrb.matrix.Matrix;
import de.lab4inf.wrb.matrix.matParallel;
import java.util.ArrayList;

public class WRBObserver extends WRBBaseVisitor<Double> {
	
	//private WRBScript script = new WRBScript();
	 HashMap<String, Double> varMemory = new HashMap<>();
	 HashMap<String, WRBFunction> funcMemory = new HashMap<>();
	
	WRBScript script;
	WRBObserver(WRBScript script) {
	    this.script = script;	
	}
	WRBObserver (){
		
	}

	//public HashMap<String, MathFunction> mathFuncMemory = script.getMathFunctionMap();
	
	@Override
	public Double visitStatement(WRBParser.StatementContext ctx) {
		if(ctx.expr() != null)
			return visit(ctx.expr());
		if(ctx.assignVar() != null)
			return visit(ctx.assignVar());
		return visit(ctx.assignFunc());
	}
	
	@Override
	public Double visitExpr(WRBParser.ExprContext ctx) {
		if(ctx.term() != null)
			return visit(ctx.term());
		else if (ctx.exprAdd() != null)
			return visit(ctx.expr()) + visit(ctx.exprAdd());
		return visit(ctx.expr()) - visit(ctx.exprSub());
	}
	
	@Override
	public Double visitExprAdd(WRBParser.ExprAddContext ctx) {
		return visit(ctx.term());
	}
	
	@Override
	public Double visitExprSub(WRBParser.ExprSubContext ctx) {
		
		return visit(ctx.term());
	}
	
	@Override
	public Double visitTerm(WRBParser.TermContext ctx) {
		
		if(ctx.termMul() != null) 
			return visit(ctx.term()) * visit(ctx.termMul());
		else if(ctx.termDiv() != null)
			return visit(ctx.term()) / visit(ctx.termDiv());
		return visit(ctx.factor());
	}
	
	@Override
	public Double visitTermMul(WRBParser.TermMulContext ctx) {
		
		return visit(ctx.factor());
	}
	
	@Override
	public Double visitTermDiv(WRBParser.TermDivContext ctx) {
		
		return visit(ctx.factor());
	}

	@Override
	public Double visitFactor(WRBParser.FactorContext ctx) {
		
		if(ctx.pow() != null)
			return Math.pow(visit(ctx.signedAtom()), visit(ctx.pow()));
		return visit(ctx.signedAtom());
	}
	

	@Override
	public Double visitPow(WRBParser.PowContext ctx) {
		
		return visit(ctx.factor());
	}
	
	
	@Override
	public Double visitSignedAtom(WRBParser.SignedAtomContext ctx) {
		
		if(ctx.SUB() != null)
			return -1. * visit(ctx.atom());
		return visit(ctx.atom());
	}
	

	@Override
	public Double visitAtom(WRBParser.AtomContext ctx) {
		
		if(ctx.expr() != null)
			return visit(ctx.expr());
		else if(ctx.function() != null) 
			return visit(ctx.function());
		else if(ctx.SCI_NO() != null)
			return Double.parseDouble(ctx.SCI_NO().getText());
		return varMemory.get(ctx.ID().getText());
	}
	

	@Override
	public Double visitFunction(WRBParser.FunctionContext ctx) {
		Double var=null;
		
		
		if(ctx.max() != null) {
			return visit(ctx.max());
		}else if(ctx.min() != null) {
			return visit(ctx.min());
		} else if(ctx.POWFUNC() != null) {
			return Math.pow(visit(ctx.e1), visit(ctx.e2));
		} 
		
		
		String id = ctx.id.getText().toLowerCase();
		var = visit(ctx.e);
		if(script.MathFuncMemory.containsKey(id)) {
			Function fct =  script.getFunction(id);
			return fct.eval(var);
		} else if(funcMemory.containsKey(id)) {
			List<WRBParser.ExprContext> exp = ctx.expr();
			double[] params = new double[exp.size()];
			int i = 0;
			for(WRBParser.ExprContext c : exp) {
				params[i] = visit(c);
				i++;
			}
			return funcMemory.get(id).eval(params);
		}
		return null;
		
	}
	
	@Override
	public Double visitMax(WRBParser.MaxContext ctx) {
		
		
		List<WRBParser.ExprContext> exp = ctx.expr();
		double[] params = new double[exp.size()];
		int i = 0;
		for(WRBParser.ExprContext c : exp) {
			params[i] = visit(c);
			i++;
		}
		
		OptionalDouble maxTemp = DoubleStream.of(params).max();
		double max = maxTemp.getAsDouble();
		return max;
		
	}
	
	@Override
	public Double visitMin(WRBParser.MinContext ctx) {
		
		List<WRBParser.ExprContext> exp = ctx.expr();
		double[] params = new double[exp.size()];
		int i = 0;
		for(WRBParser.ExprContext c : exp) {
			params[i] = visit(c);
			i++;
		}
		
		OptionalDouble minTemp = DoubleStream.of(params).min();
		double min = minTemp.getAsDouble();
		return min;
	}
	
	@Override
	public Double visitAssignVar(WRBParser.AssignVarContext ctx) {
		
		if(ctx.expr() != null) {
			Double var = visit(ctx.expr());
			varMemory.put(ctx.i.getText(), var);
			return var;
		} else {
			Double var = varMemory.get(ctx.j.getText());
			varMemory.put(ctx.i.getText(), var);
			return var;
		}
	}
	
	@Override
	public Double visitAssignFunc(WRBParser.AssignFuncContext ctx) {
		
		
		
		String id = ctx.i.getText();
		String p = ctx.p.getText();
		String[] params = p.split(",");
		
		HashMap<String, Double> varMemoryTemp = new HashMap<>();
		
		for(String param : params) {
			if(varMemory.containsKey(param)) {
				varMemoryTemp.put(param, varMemory.get(param));
				varMemory.remove(param);
			}
				
		}
		WRBFunction fct = new WRBFunction(params, ctx.expr(), varMemory, script, this);
		
		funcMemory.put(id, fct);
		fct.getFunctionMemory(funcMemory);
		varMemory.putAll(varMemoryTemp);
		return Double.valueOf(1);
		
	}
}
