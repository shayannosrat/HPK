package de.lab4inf.wrb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import static org.junit.Assert.assertTrue;

public class OwnSimpleTests {
    final double eps = 1.E-8;
    Script script;
    
    @Before
    public final void setUp() throws Exception {
        script = getScript();
        assertNotNull("no script implementation", script);
    }
    
    protected Script getScript() {
        return new WRBScript();
    }
    
    @Test
    public final void testInnerSQRT() throws Exception {
        String task="SQRT(SQRT(SQRT(SQRT(200))))";
        assertEquals(1.3925614699132163, script.parse(task), eps);
    }
    
    @Test
    public final void testLongIntMul() throws Exception{
    	String task="a=23423525245345634523453423423425455234543; a*a*a";
    	assertEquals(1.2851587314333343E121,script.parse(task),eps);
    }
    
    @Test
    public final void testLongDoubleMul() throws Exception{
    	String task="a=23423525245345634523453423423425455.023423423564565234543; a*a*a";
    	assertEquals(1.2851587314333345E103,script.parse(task),eps);
    }
    
    @Test
    public final void testInfinityInt() throws Exception{
    	String task="a=999; b=a^a; b";
    	script.parse(task);
    	double res2= Double.POSITIVE_INFINITY;
    	//String test =String.valueOf(script.getVariable("b"));
    	//String res ="Infinity";
    	assertEquals(res2, script.parse(task), eps);
    	//assertTrue(.equals(res));
    }
    
    @Test
    public final void testNegativeSqrt() throws Exception{
    	String task="a=SQRT(-10)";
    	script.parse(task);
    	String test =String.valueOf(script.getVariable("a"));
    	String res ="NaN";
    	assertTrue(test.equals(res));
    }
    
    @Test
    public final void testNegativeMul() throws Exception{
    	String task="-2 * -2;";
    	assertEquals(4.0,script.parse(task),eps);
    }
    
    @Test(expected = Exception.class)
    public final void testEmptyInput() throws Exception {
        String task = "\n";
        script.parse(task);
    }
}
