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
     * Parse the given String into an internal representation (e.g. as AST) and
     * evaluate the expression(s).
     * @param definition of the script expression(s) as a String
     * @return the result of the parsed evaluation
     */
	public double parse(String definition) throws IllegalArgumentException{
		CharStream inputStream = CharStreams.fromString(definition+'\n');
		WRBLexer lexer = new WRBLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r)); // Ergebnis ausgeben
			
		} catch(Exception e) {
			throw new IllegalArgumentException("Ungültige Eingabe");
		}
		return lastResult;
	}
	
	/**
     * Parse the InputStream into an internal representation (e.g. as AST) and
     * evaluate the expression(s).
     * @param defStream of the script expression(s) as InputStream
     * @return the result of the parsed evaluation
     * @throws IOException in case of a stream I/O error
     */
	public double parse(InputStream defStream) throws IOException {
		CharStream inputStream = CharStreams.fromStream(defStream);
		WRBLexer lexer = new WRBLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r)); // Ergebnis ausgeben
			
		} catch(Exception e) {
			throw new IllegalArgumentException("Ungültige Eingabe");
		}
		return lastResult;
	}
	
	/**
     * Get all script known variable names.
     * @return set with the variables names
     */
	public Set<String> getVariableNames() {
		return parser.getMemory().keySet();
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
	public void setFunction(String name, Function fct) {}
	
	/**
     * Get all script known function names.
     * @return set with the function names
     */
	public Set<String> getFunctionNames() {
		return new HashSet<String>();
	}
	
	/**
     * Get a (unique!) named function.
     * @param name of the function
     * @return an implementation
     */
	public Function getFunction(String name) {
		return null;
	}
}
