package de.lab4inf.wrb;

import java.util.HashMap;


public class WRBFunction implements Function {
	
	WRBScript script;
	WRBObserver ob;
	
	private String[] paramNames;
	private WRBParser.ExprContext ctx;
	HashMap<String, Double> scope = new HashMap<>();
	

	public WRBFunction(String[] paramNames, WRBParser.ExprContext ctx, HashMap<String, Double> varMemory, WRBScript script, WRBObserver ob) {
		this.paramNames = paramNames;
		this.ctx = ctx;
		ob.varMemory = varMemory;
		this.script = script;
		this.ob = ob;
		
	}
	
	public String[] getParamNames() {
		return paramNames;
	}
	
	@Override
	public double eval(double... args) {
		scope.putAll(ob.varMemory);
		int i = 0;
		for(double arg : args) {
			scope.put(paramNames[i], arg);
			i++;
			
		}
		
		
		return eval(scope);
	}

	public double eval(HashMap<String, Double> sc) {
		
		ob.varMemory = sc;
		
		return ob.visit(ctx);
		
	}
	
	public void getFunctionMemory(HashMap<String, WRBFunction> funcMemory) {
		
		ob.funcMemory = funcMemory;
	}
	
}