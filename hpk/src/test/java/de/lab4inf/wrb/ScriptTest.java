package de.lab4inf.wrb;

public class ScriptTest extends AbstractScriptTest{
	@Override
	protected Script getScript() {
        return new WRBScript();
    }
}
