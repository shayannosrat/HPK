package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class WRBScript implements Script {
	private WRBParser.RunContext r;
	private WRBParser parser = new WRBParser(null);
	private final WRBObserver ob = new WRBObserver();
	
	private static double lastResult;
	
	public WRBScript() {}
	
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
	public void setFunction(String name, WRBFunction fct) {
		ob.funcMemory.put(name, fct);
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
	public WRBFunction getFunction(String name) throws IllegalArgumentException{
		if(ob.funcMemory.containsKey(name))
			return ob.funcMemory.get(name);
		else
			throw new IllegalArgumentException("Funktion existiert nicht!");
	}
	
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
