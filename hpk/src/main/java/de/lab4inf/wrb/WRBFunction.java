package de.lab4inf.wrb;

import java.util.HashMap;
import java.util.Set;


public class WRBFunction implements Function {
	WRBObserver ob;
	private String[] paramNames;
	private WRBParser.ExprContext ctx;
	HashMap<String, Double> scope = new HashMap<>();
	
	public WRBFunction(String[] paramNames, WRBParser.ExprContext ctx) {
		this.paramNames = paramNames;
		this.ctx = ctx;
	}
	
	public String[] getParamNames() {
		return paramNames;
	}
	
	@Override
	public double eval(double... args) {
		int i = 0;
		for(double arg : args) {
			scope.put(paramNames[i], arg);
			System.out.println(paramNames[i] + " , " + arg);
			i++;
			
		}
		
		
		return ob.visit(ctx.expr());
	}

}