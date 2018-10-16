package de.lab4inf.wrb;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

public class WRBScript implements Script {
	public WRBScript() {}
	
	public double parse(String definition) {
		return 0;
	}
	
	public double parse(InputStream defStream) throws IOException {
		return 0;
	}
	
	public Set<String> getFunctionNames() {
		return new HashSet<String>();
	}
	
	public Set<String> getVariableNames() {
		return new HashSet<String>();
	}
	
	public void setFunction(String name, Function fct) {}
	
	public Function getFunction(String name) {
		return null;
	}
	
	public double getVariable(String name) {
		return 0;
	}
	
	public void setVariable(String name, double value) {}
}
