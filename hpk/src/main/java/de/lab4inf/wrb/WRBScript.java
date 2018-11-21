package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import de.lab4inf.wrb.WRBFunction.MathFunction;


public class WRBScript implements Script {
	private WRBParser.RunContext r;
	private WRBParser parser = new WRBParser(null);
	private final WRBObserver ob = new WRBObserver();
	
	
	
	static MathFunction abs = (value) -> Math.abs(value[0]);
	static MathFunction acos = (value) -> Math.acos(value[0]);
	static MathFunction asin = (value) -> Math.asin(value[0]);
	static MathFunction atan = (value) -> Math.atan(value[0]);
	static MathFunction cbrt = (value) -> Math.cbrt(value[0]);
	static MathFunction ceil = (value) -> Math.ceil(value[0]);
	static MathFunction cos = (value) -> Math.cos(value[0]);
	static MathFunction cosh = (value) -> Math.cosh(value[0]);
	static MathFunction exp = (value) -> Math.exp(value[0]);
	static MathFunction expm1 = (value) -> Math.expm1(value[0]);
	static MathFunction floor = (value) -> Math.floor(value[0]);
	static MathFunction ln = (value) -> Math.log(value[0]);
	static MathFunction loge = (value) -> Math.log(value[0]);
	static MathFunction log = (value) -> Math.log10(value[0]);
	static MathFunction log10 = (value) -> Math.log10(value[0]);
	static MathFunction log2 = (value) -> Math.log(value[0])/Math.log(2);
	static MathFunction ld = (value) -> Math.log(value[0])/Math.log(2);
	static MathFunction lb = (value) -> Math.log(value[0])/Math.log(2);
	static MathFunction pow = (value) -> Math.pow(value[0], value[1]);
	static MathFunction rint = (value) -> Math.rint(value[0]);
	static MathFunction signum = (value) -> Math.signum(value[0]);
	static MathFunction sin = (value) -> Math.sin(value[0]);
	static MathFunction sinh = (value) -> Math.sinh(value[0]);
	static MathFunction sqrt = (value) -> Math.sqrt(value[0]);
	static MathFunction tan = (value) -> Math.tan(value[0]);
	static MathFunction tanh = (value) -> Math.tanh(value[0]);
	
	/* MathFunction abs = (value) -> Math.abs(value[0]);
	 MathFunction acos = (value) -> Math.acos(value[0]);
	 MathFunction asin = (value) -> Math.asin(value[0]);
	 MathFunction atan = (value) -> Math.atan(value[0]);
	 MathFunction cbrt = (value) -> Math.cbrt(value[0]);
	 MathFunction ceil = (value) -> Math.ceil(value[0]);
	 MathFunction cos = (value) -> Math.cos(value[0]);
	 MathFunction cosh = (value) -> Math.cosh(value[0]);
	 MathFunction exp = (value) -> Math.exp(value[0]);
	 MathFunction expm1 = (value) -> Math.expm1(value[0]);
	 MathFunction floor = (value) -> Math.floor(value[0]);
	 MathFunction ln = (value) -> Math.log(value[0]);
	 MathFunction loge = (value) -> Math.log(value[0]);
	 MathFunction log = (value) -> Math.log10(value[0]);
	 MathFunction log10 = (value) -> Math.log10(value[0]);
	 MathFunction log2 = (value) -> Math.log(value[0]);
	 MathFunction ld = (value) -> Math.log(value[0]);
	 MathFunction lb = (value) -> Math.log(value[0]);
	 MathFunction pow = (value) -> Math.pow(value[0], value[1]);
	 MathFunction rint = (value) -> Math.rint(value[0]);
	 MathFunction signum = (value) -> Math.signum(value[0]);
	 MathFunction sin = (value) -> Math.sin(value[0]);
	 MathFunction sinh = (value) -> Math.sinh(value[0]);
	 MathFunction sqrt = (value) -> Math.sqrt(value[0]);
	 MathFunction tan = (value) -> Math.tan(value[0]);
	 MathFunction tanh = (value) -> Math.tanh(value[0]);*/
	
	public static HashMap<String, MathFunction> MathFuncMemory = new HashMap<>();
	static {
		MathFuncMemory = new HashMap<>();
		MathFuncMemory.put("abs",abs);
		MathFuncMemory.put("acos",acos);
		MathFuncMemory.put("asin",asin);
		MathFuncMemory.put("atan",atan);
		MathFuncMemory.put("cbrt",cbrt);
		MathFuncMemory.put("ceil",ceil);
		MathFuncMemory.put("cos",cos);
		MathFuncMemory.put("cosh",cosh);
		MathFuncMemory.put("exp",exp);
		MathFuncMemory.put("expm1",expm1);
		MathFuncMemory.put("floor",floor);
		MathFuncMemory.put("ln",ln);
		MathFuncMemory.put("loge",loge);
		MathFuncMemory.put("log",log);
		MathFuncMemory.put("log10",log10);
		MathFuncMemory.put("log2",log2);
		MathFuncMemory.put("ld",ld);
		MathFuncMemory.put("lb",lb);
		MathFuncMemory.put("pow",pow);
		MathFuncMemory.put("rint",rint);
		MathFuncMemory.put("signum",signum);
		MathFuncMemory.put("sin",sin);
		MathFuncMemory.put("sinh",sinh);
		MathFuncMemory.put("sqrt",sqrt);
		MathFuncMemory.put("tan",tan);
		MathFuncMemory.put("tanh",tanh);
	}
	
	/*{
	MathFuncMemory.put("abs",abs);
	MathFuncMemory.put("acos",acos);
	MathFuncMemory.put("asin",asin);
	MathFuncMemory.put("atan",atan);
	MathFuncMemory.put("cbrt",cbrt);
	MathFuncMemory.put("ceil",ceil);
	MathFuncMemory.put("cos",cos);
	MathFuncMemory.put("cosh",cosh);
	MathFuncMemory.put("exp",exp);
	MathFuncMemory.put("expm1",expm1);
	MathFuncMemory.put("floor",floor);
	MathFuncMemory.put("ln",ln);
	MathFuncMemory.put("loge",loge);
	MathFuncMemory.put("log",log);
	MathFuncMemory.put("log10",log10);
	MathFuncMemory.put("log2",log2);
	MathFuncMemory.put("ld",ld);
	MathFuncMemory.put("lb",lb);
	MathFuncMemory.put("pow",pow);
	MathFuncMemory.put("rint",rint);
	MathFuncMemory.put("signum",signum);
	MathFuncMemory.put("sin",sin);
	MathFuncMemory.put("sinh",sinh);
	MathFuncMemory.put("sqrt",sqrt);
	MathFuncMemory.put("tan",tan);
	MathFuncMemory.put("tanh",tanh);
	}*/
	
	private static double lastResult;
	
	public WRBScript() {
		
		
		
	}
	
	/**
     * Parse the given String into an internal representation and
     * evaluate the expression(s).
     * @param definition of the script expression(s) as a String
     * @return the result of the parsed evaluation
     */
	public double parse(String definition) throws IllegalArgumentException{
		CharStream inputStream = CharStreams.fromString(definition+'\n');
		WRBLexer lexer = new WRBLexer(inputStream);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		parser.removeErrorListeners();
		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r)); // Ergebnis ausgeben
		} catch (Exception e) {
			throw new IllegalArgumentException("Ungltige Eingabe!");
		}

		return lastResult;
	}
	
	/**
     * Parse the InputStream into an internal representation and
     * evaluate the expression(s).
     * @param defStream of the script expression(s) as InputStream
     * @return the result of the parsed evaluation
     * @throws IOException in case of a stream I/O error
     */
	public double parse(InputStream defStream) throws IOException {
		CharStream inputStream = CharStreams.fromStream(defStream);
		WRBLexer lexer = new WRBLexer(inputStream);
		lexer.removeErrorListeners();
		lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		parser.removeErrorListeners();
		parser.addErrorListener(ThrowingErrorListener.INSTANCE);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r)); // Ergebnis ausgeben
		} catch (Exception e) {
			throw new IllegalArgumentException("Ungltige Eingabe!");
		}
			
		return lastResult;
	}
	
	/**
     * Get all script known variable names.
     * @return set with the variables names
     */
	public Set<String> getVariableNames() {
		return ob.varMemory.keySet();
	}
		
	/**
     * Get the value of a (unique!) named variable.
     * @param name of the variable
     * @return the actual variable value
     */
	public double getVariable(String name) {
		return parse(name);
	}
	
	/**
     * Set the value of a named variable.
     * @param name of the variable to be unique
     * @param value the new variable setting
     */
	public void setVariable(String name, double value) {
		String expr = name+'='+Double.toString(value);
		parse(expr);
	}
	
	/**
     * Add a named function to this script.
     * @param name of the function to be unique
     * @param fct to add 
     */
	public void setFunction(String name, Function fct) {
		ob.funcMemory.put(name, (WRBFunction) fct);
	}
	
	/**
     * Get all script known function names.
     * @return set with the function names
     */
	public Set<String> getFunctionNames() {
		return ob.funcMemory.keySet();
	}
	
	

	/**
     * Get a (unique!) named function.
     * @param name of the function
     * @return an implementation
     */
	public Function getFunction(String name) throws IllegalArgumentException{
		
		 if(ob.funcMemory.containsKey(name)) {
			return ob.funcMemory.get(name);
		} else if(MathFuncMemory.containsKey(name)) {
			return (Function) MathFuncMemory.get(name);
		} 
		 else {
			throw new IllegalArgumentException("Funktion existiert nicht!");
		}
	}
	
	public static HashMap<String, MathFunction> getMathFunctionMap(){
		
		return MathFuncMemory;
	}
	
	/*public static MathFunction getMathFunction(String name) throws IllegalArgumentException{
		if(MathFuncMemory.containsKey(name)) {
			return MathFuncMemory.get(name);
		} else {
			throw new IllegalArgumentException("Funktion existiert nicht!");
		}
	}*/
	
	@Override
	public Script concat(Script that) {
		Script ret = new WRBScript();
		
		// old fashion JDK 1.5 for-loop
        for (String varName : that.getVariableNames()) {
            double var = that.getVariable(varName);
            ret.setVariable(varName, var);
        }
        // new style for-each-loop with lambda expression
        this.getFunctionNames().forEach((fctName) -> {
            ret.setFunction(fctName, this.getFunction(fctName));
        });
        that.getFunctionNames().forEach((fctName) -> {
            ret.setFunction(fctName, that.getFunction(fctName));
        });
		
		return ret;
	}
}
