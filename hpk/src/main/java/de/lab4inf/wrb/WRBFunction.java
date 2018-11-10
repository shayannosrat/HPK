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
		
		return eval(scope);
	}
	
	public double eval(HashMap<String, Double> sc) {
		System.out.println("bin in scope");
		System.out.println(scope);
		
		double[] evalValue = new double[sc.size()];
		double[] params = new double[sc.size()];
		Set<String> keys = sc.keySet();
		int i = 0;
		
		for(String key : keys) {
			params[i] = sc.get(key);
			i++;
		}
		return ob.visit(ctx.expr()) ;
	}

}