package de.lab4inf.wrb;

import java.util.HashMap;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

import de.lab4inf.wrb.WRBFunction.MathFunction;
import de.lab4inf.wrb.matrix.Matrix;
import de.lab4inf.wrb.matrix.ParallelMultiplier;
import java.util.ArrayList;

public class WRBObserver extends WRBBaseVisitor<Double> {
	
	//private WRBScript script = new WRBScript();
	public HashMap<String, Double> varMemory = new HashMap<>();
	public HashMap<String, WRBFunction> funcMemory = new HashMap<>();
	public HashMap<String, MathFunction> mathFuncMemory = WRBScript.getMathFunctionMap();
	public HashMap<String, Matrix> matMemory = new HashMap<>();
	protected Script script;
	
	@Override
	public Double visitStatement(WRBParser.StatementContext ctx) {
		if(ctx.expr() != null)
			return visit(ctx.expr());
		if(ctx.assignVar() != null)
			return visit(ctx.assignVar());
		if(ctx.assignMatrix() != null)
			return visit(ctx.assignMatrix());
		if(ctx.matrixMult() != null)
			return visit(ctx.matrixMult());
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
	public Double visitMatrixMult(WRBParser.MatrixMultContext ctx) {
		Matrix A; 
		Matrix B;
		
		for(WRBParser.VectorContext v : ctx.a.vector()) {
			if(! (v.SCI_NO().size() == ctx.a.vector(0).SCI_NO().size()))
				throw new IllegalArgumentException("Zeilen der Matrix A müssen die gleiche Anzahl an Elementen enthalten!");
		}
		
		for(WRBParser.VectorContext v : ctx.b.vector()) {
			if(! (v.SCI_NO().size() == ctx.b.vector(0).SCI_NO().size()))
				throw new IllegalArgumentException("Zeilen der Matrix B müssen die gleiche Anzahl an Elementen enthalten!");
		}
		
		double[][] a = new double[ctx.a.vector().size()][ctx.a.vector(0).SCI_NO().size()];
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				a[i][j] = Double.parseDouble(ctx.a.vector(i).SCI_NO(j).getText());
			}
		}
		
		double[][] b = new double[ctx.b.vector().size()][ctx.b.vector(0).SCI_NO().size()];
		
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				b[i][j] = Double.parseDouble(ctx.b.vector(i).SCI_NO(j).getText());
			}
		}
		
		A = new Matrix(a);
		B = new Matrix(b);
		
		Matrix res = ParallelMultiplier.multiply(A, B);
		
		System.out.println(res.toString());
		
		
		return 1.0;
	}
	
	@Override
	public Double visitAssignMatrix(WRBParser.AssignMatrixContext ctx) throws IllegalArgumentException{
		String id = ctx.i.getText();
		for(WRBParser.VectorContext v : ctx.m.vector()) {
			if(! (v.SCI_NO().size() == ctx.m.vector(0).SCI_NO().size()))
				throw new IllegalArgumentException("Zeilen der Matrix müssen die gleiche Anzahl an Elementen enthalten!");
		}
			
		double[][] m = new double[ctx.m.vector().size()][ctx.m.vector(0).SCI_NO().size()];
					
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				m[i][j] = Double.parseDouble(ctx.m.vector(i).SCI_NO(j).getText());
			}
		}
		
		Matrix M = new Matrix(m);
		
		System.out.println("Saved " + id + ":\n" + M.toString());
		
		matMemory.put(id, M);
		
		return 1.0;
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
		
		String id = ctx.id.getText();
		var = visit(ctx.e);
		if(mathFuncMemory.containsKey(id)) {
			MathFunction fct =  mathFuncMemory.get(id);
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
		
		System.out.println("visiteed max");
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
		System.out.println("visited assignVar");
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
		System.out.println("visited assignFunc");
		
		
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
		WRBFunction fct = new WRBFunction(params, ctx.expr(), varMemory);
		
		funcMemory.put(id, fct);
		fct.getFunctionMemory(funcMemory);
		varMemory.putAll(varMemoryTemp);
		return Double.valueOf(1);
		
	}
}
