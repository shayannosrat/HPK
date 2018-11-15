package de.lab4inf.wrb;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ScriptTest extends AbstractScriptTest{
	@Override
	protected Script getScript() {
        return new WRBScript();
    }
	
	
	
}
