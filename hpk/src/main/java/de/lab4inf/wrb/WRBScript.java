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
	
	public double parse(String definition) throws IllegalArgumentException{
		CharStream inputStream = CharStreams.fromString(definition+'\n');
		WRBLexer lexer = new WRBLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r));// Ergebnis ausgeben
			
		} catch(Exception e) {
			throw new IllegalArgumentException("Ungültige Eingabe");
		}
		return lastResult;
	}
	
	public double parse(InputStream defStream) throws IOException {
		CharStream inputStream = CharStreams.fromStream(defStream);
		WRBLexer lexer = new WRBLexer(inputStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		
		parser.setTokenStream(tokenStream);
		
		try {
			r = parser.run(); // Token-Stream parsen
			lastResult = Double.valueOf(ob.visitRun(r));// Ergebnis ausgeben
			
		} catch(Exception e) {
			throw new IllegalArgumentException("Ungültige Eingabe");
		}
		return lastResult;
	}
	
	public Set<String> getVariableNames() {
		return new HashSet<String>();
	}
		
	
	public double getVariable(String name) {
		return parse(name);
	}
	
	public void setVariable(String name, double value) {
		String expr = name+'='+Double.toString(value);
		parse(expr);
	}
	
	public void setFunction(String name, Function fct) {}
	
	public Set<String> getFunctionNames() {
		return new HashSet<String>();
	}
	
	public Function getFunction(String name) {
		return null;
	}
}
