/*
 * Project: WRB
 *
 * Copyright (c) 2008-2013,  Prof. Dr. Nikolaus Wulff
 * University of Applied Sciences, Muenster, Germany
 * Lab for Computer Sciences (Lab4Inf).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package de.lab4inf.wrb;

import static java.lang.Math.abs;
import static java.lang.Math.acos;
import static java.lang.Math.asin;
import static java.lang.Math.atan;
import static java.lang.Math.cos;
import static java.lang.Math.cosh;
import static java.lang.Math.exp;
import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.random;
import static java.lang.Math.sin;
import static java.lang.Math.sinh;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Test of the WRB-Script language.
 * 
 * @author nwulff
 * @since 16.10.2013
 * @version $Id: AbstractScriptTest.java,v 1.27 2018/10/23 16:31:40 nwulff Exp $
 */
public abstract class AbstractScriptTest {
    /**
     * 
     */
    protected static final String NO_EXCEPTION_THROWN = "no Exception thrown";
    /** some powers of 10 for quick digit position calculations. */
    private static long[] pow10 = { 1, 10, 100, 1000, 10000, 100000, 1000000, 100000000, 10000000000L };
    /** the default digits after the decimal point. */
    private static final int DEFAULT_DIGITS = 3;
    /** save the default system error stream.       */
    private static final PrintStream SYSERR = System.err;
    /** messages accumulated during the test.       */
    protected static List<String> errorMessages = new ArrayList<>();
    /** access to some test informations.           */
    public @Rule TestInfo tm = new TestInfo();
    /** Name of the running test method.            */
    private String testName;
    /** the default precision to reach for floating point arithmetic. */
    protected static final double EPS = 1.E-8;
    /** the script instance to test. */
    protected Script script;

    class TestInfo extends TestWatcher {
        private String method;
        String clazz;
        String namespace;

        @Override
        protected void starting(final Description d) {
            method = d.getMethodName();
            clazz = d.getClassName();
            namespace = "<default>";
            final int dot = clazz.lastIndexOf('.');
            if (dot>0) {
                namespace = clazz.substring(0, dot);
                clazz = clazz.substring(dot+1);
            }
        }

        /**
         * @return the name of the currently-running test method
         */
        public String getMethodName() {
            return method;
        }

        public String getClassName() {
            return clazz;
        }

        public String getPackageName() {
            return namespace;
        }
    }

    static class JUnitTestPrintStream extends PrintStream {
        static final String LINE = "line";

        /**
         * Constructor with underlying output stream.
         * @param out
         */
        public JUnitTestPrintStream(final OutputStream out) {
            super(out);
        }

        @Override
        public void println(final String s) {
            if (null!=s&&s.startsWith(LINE)) {
                errorMessages.add(s);
            } else {
                super.println(s);
            }
        }

        @Override
        public void print(final String s) {
            if (null!=s&&s.startsWith(LINE)) {
                errorMessages.add(s);
            } else {
                super.print(s);
            }
        }
    }

    protected AbstractScriptTest() {
        System.setErr(new JUnitTestPrintStream(System.err));
    }

    /**
     * Dice a random number between -1 and 1 with the given positions after the decimal point.
     * @param position number of digits after the decimal point
     * @return random number
     */
    protected static double rnd(final int position) {
        if (position<0||position>=pow10.length) {
            String msg = String.format("wrong number of digits %d", position);
            throw new IllegalArgumentException(msg);
        }
        final long p10 = pow10[position];
        return floor((random()-0.5)*(p10<<1))/p10;
    }

    /**
     * Dice a random number between -1 and 1 with default three positions after the decimal point.
     * @return random number
     */
    protected static double rnd() {
        return rnd(DEFAULT_DIGITS);
    }

    /**
     * Format a String with the US locale, e.g. exchange the comma with a period for double or float.
     * @param fmt format to use
     * @param args the arguments to format
     * @return formated String 
     */
    protected static String format(String fmt, Object... args) {
        return String.format(Locale.US, fmt, args);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public final void scriptTestTearDown() throws Exception {
        System.setErr(SYSERR);
        int numErrors = errorMessages.size();
        try {
            if (numErrors>0) {
                System.err.printf("%s logged #%d Antlr error messages \n", testName, numErrors);
                for (String err : errorMessages) {
                    System.err.println(err);
                }
                errorMessages.clear();
                fail(format("#%d Antlr error messages logged", numErrors));
            }
        } finally {
            tearDown();
        }
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public final void scriptTestSetUp() throws Exception {
        testName = tm.getMethodName();
        script = getScript();
        assertFalse(script==null);
        assertNotNull("no script implementation", script);
    }

    /**
     * Override the test setup if needed.
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Override the test cleanup if needed.
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Factory method, get a fresh script implementation for the test.
     *  
     * Note: This method can be  called several times during one test case
     * and should return independent scripts.
     * 
     * @return script implementation
     */
    protected abstract Script getScript();

    /**
     * Test method for
     * {@link de.lab4inf.wrb.Script#getVariable(java.lang.String)}.
     */
    @Test(expected = IllegalArgumentException.class)
    public final void testGetUnknownVariable() throws Exception {
        String key = "dummy";
        script.getVariable(key);
    }

    /**
     * Test method for
     * {@link de.lab4inf.wrb.Script#setVariable(java.lang.String,double)}. and
     * {@link de.lab4inf.wrb.WRBScript#getVariable(java.lang.String)}.
     */
    @Test
    public final void testSetGetVariable() throws Exception {
        double y, x = rnd();
        String key = "XYZ";
        script.setVariable(key, x);
        y = script.getVariable(key);
        assertEquals(x, y, EPS);
    }

    @Test
    public final void testAssignWithSemi() throws Exception {
        String task = "x = 4; ";
        assertEquals(4, script.parse(task), EPS);
    }

    @Test
    public final void testLazyFloat() throws Exception {
        String task = "2 + .31";
        assertEquals(2.31, script.parse(task), EPS);
    }

    //    @Test
    //    @Ignore
    //    public final void testAssignSignedVar() throws Exception {
    //        String task = "x = 2.5; a= -x; ";
    //        assertEquals( -2.5, script.parse(task), EPS);
    //        assertEquals(2.5, script.getVariable("x"), EPS);
    //        assertEquals( -2.5, script.getVariable("a"), EPS);
    //    }

    @Test
    public final void testAssignWithOutSemi() throws Exception {
        String task = "x = 5.1 ";
        assertEquals(5.1, script.parse(task), EPS);
        assertEquals(5.1, script.getVariable("x"), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testMultiAssignWithOutSemi() throws Exception {
        String task = "x = 5 y = x ";
        script.parse(task);
    }

    @Test
    public final void testSetGetParseVariables() throws Exception {
        double y, x1 = rnd(), x2 = -rnd();
        String task = format("x1=%.3f; Y2=%.3f; w=x1*Y2;", x1, x2);
        script.parse(task);
        y = script.getVariable("x1");
        assertEquals(x1, y, EPS);
        y = script.getVariable("Y2");
        assertEquals(x2, y, EPS);
        y = script.getVariable("w");
        assertEquals(x1*x2, y, EPS);
    }

    @Test
    public final void testVariableMultipleTimes() throws Exception {
        double y, x1, x2;
        for (int k = 0; k<10; k++ ) {
            x1 = rnd();
            x2 = rnd();
            String task = format("a=%.3f; b=%.3f", x1, x2);
            script.parse(task);
            y = script.getVariable("a");
            assertEquals(x1, y, EPS);
            y = script.getVariable("b");
            assertEquals(x2, y, EPS);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testSetIllegalVariable() throws Exception {
        String task = "1a=3";
        script.parse(task);
        fail("illegal variable name assignment: "+task);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testGetIllegalVariable() throws Exception {
        String task = "x=3; y =4x+3";
        script.parse(task);
        fail("illegal variable name or lazy multiplication: "+task);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testWrongSyntax() throws Exception {
        String task = "2 +/ 3";
        try {
            script.parse(task);
            fail(NO_EXCEPTION_THROWN);
        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            throw e;
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testWrongSymbol() throws Exception {
        String task = "2.1  x";
        try {
            script.parse(task);
            fail(NO_EXCEPTION_THROWN);
        } catch (IllegalArgumentException e) {
            // e.printStackTrace(); // just to check what has happend ...
            throw e;
        }
    }

    /**
     * Test method for {@link de.lab4inf.wrb.Script#parse(java.lang.String)}.
     */
    @Test
    public final void testPlus() throws Exception {
        String task = "2+3";
        assertEquals(5.0, script.parse(task), EPS);
    }

    @Test
    public final void testTinyPlus() throws Exception {
        String task = "2.0e-5 + 3.0e+1";
        assertEquals(30.00002, script.parse(task), EPS);
    }

    @Test
    public final void testMinus() throws Exception {
        String task = "2 - 6";
        assertEquals( -4.0, script.parse(task), EPS);
    }

    @Test
    public final void testTinyMinus() throws Exception {
        String task = "2.0e-5 - 3.0e+1";
        assertEquals( -29.99998, script.parse(task), EPS);
    }

    @Test
    public final void testConstant() throws Exception {
        String task = "0815; 4711;";
        assertEquals(4711.0, script.parse(task), EPS);
    }

    @Test
    public final void testSigned() throws Exception {
        String task = "-2 + 6";
        assertEquals(4.0, script.parse(task), EPS);
    }

    @Test
    public void testSignedSecondArg() throws Exception {
        String task = "2 + -6.0";
        assertEquals( -4.0, script.parse(task), EPS);
    }

    @Test
    public void testSignedMinusArg() throws Exception {
        String task = "2 - -6";
        assertEquals(8.0, script.parse(task), EPS);
    }

    @Test
    public void testSignedMultArg() throws Exception {
        String task = "2 * -6";
        assertEquals( -12., script.parse(task), EPS);
    }

    @Test
    public void testSignedDivArg() throws Exception {
        String task = "2.0 / -6";
        assertEquals( -1./3., script.parse(task), EPS);
    }

    @Test
    public final void testMixedFloat() throws Exception {
        String task = "2.0/3 -5.2*4";
        assertEquals(2./3.0-5.2*4, script.parse(task), EPS);
    }

    @Test
    public final void testLongAddMinus() throws Exception {
        String task = "2.0 + -5 - 4.0  + 3 - 5";
        assertEquals( -9, script.parse(task), EPS);
    }

    @Test
    public final void testLongMultDiv() throws Exception {
        String task = "2 * 3.1 / 5 * 4";
        assertEquals(2*3.1/5.*4., script.parse(task), EPS);
    }

    @Test
    public final void testLongDivDiv() throws Exception {
        String task = "2 / 3.0 / 5 ";
        assertEquals((2./3.)/5., script.parse(task), EPS);
    }

    //    @Test
    //    public final void testLongMixed() throws Exception {
    //        String task = "2.0 * 3 * 4.0 - 5 + 6.0 / 3 ";
    //        assertEquals(21, script.parse(task), EPS);
    //    }

    @Test
    public void testParseBracket() throws Exception {
        String task = " 2*(4.0 + 3)";
        assertEquals(14, script.parse(task), EPS);
    }

    @Test
    public final void testParsePlusBrackets() throws Exception {
        String task = " (2+5)/(4 + (3 + 3)/2)";
        assertEquals(1.0, script.parse(task), EPS);
    }

    //    @Test
    //    public final void testAssignMultiLineEval() throws Exception {
    //        String task = "x = 4; y=x*x; z=x-y";
    //        assertEquals( -12, script.parse(task), EPS);
    //        assertEquals(4, script.getVariable("x"), EPS);
    //        assertEquals(16, script.getVariable("y"), EPS);
    //        assertEquals( -12, script.getVariable("z"), EPS);
    //    }

    @Test
    public final void testParseMultBrackets() throws Exception {
        String task = " (2.0+5)*(-4.0 + 3)";
        assertEquals( -7.0, script.parse(task), EPS);
    }

    @Test
    public final void testParseDivBrackets() throws Exception {
        String task = " (-2 + 5.0)/(14.0 -3)";
        assertEquals(3.0/11., script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedMultBrackets() throws Exception {
        String task = " -(2+5)*(-4 + 3)";
        assertEquals(7.0, script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedDivBrackets() throws Exception {
        String task = " -(-2 + 5)/(14 -3)";
        assertEquals( -3.0/11., script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedMultBrackets2() throws Exception {
        String task = " (2+5)*-(-4 + 3)";
        assertEquals(7.0, script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedDivBrackets2() throws Exception {
        String task = " (-2 + 5)/-(14 -3)";
        assertEquals( -3.0/11., script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedMultBrackets3() throws Exception {
        String task = " -(2+5)*-(-4 + 3)";
        assertEquals( -7.0, script.parse(task), EPS);
    }

    @Test
    public final void testParseSignedDivBrackets3() throws Exception {
        String task = "-(-2 + 5)/-(14 -3)";
        assertEquals(3.0/11., script.parse(task), EPS);
    }

    @Test
    public final void testParseManyBrackets() throws Exception {
        String task = "((((-2 + 5)+0)+0)*1)/((2*(((14 -3)+0)+0))/2)";
        assertEquals(3.0/11., script.parse(task), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testParseWrongBrackets1() throws Exception {
        String task = "((-2 + 5})";
        script.parse(task);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testParseWrongBrackets2() throws Exception {
        String task = "-2 + 5)))";
        script.parse(task);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testParseWrongBrackets3() throws Exception {
        String task = "((-2 + 5)+0)+0)*1)/((2*(((14 -3)+0)+0))/2)";
        script.parse(task);
    }

    @Test
    public void testParsePowRoof() throws Exception {
        String task = " 2 ^ 3";
        assertEquals(8, script.parse(task), EPS);
    }

    @Test
    public void testParsePowStars() throws Exception {
        String task = " 2 ** 4";
        assertEquals(16, script.parse(task), EPS);
    }

    @Test
    public void testParsePowBracket() throws Exception {
        String task = " 3 ^ (4 - 5)";
        assertEquals(1./3., script.parse(task), EPS);
    }

    @Test
    public void testParsePowRang() throws Exception {
        double a = rnd(), b = 2+rnd(), c = rnd(), d = rnd(), e = rnd();
        String task = format("%.3f*%.3f**(%.3f - %.3f) + %.3f", a, b, c, d, e);
        assertEquals(a*pow(b, c-d)+e, script.parse(task), EPS);
    }

    @Test
    public void testParsePowOrder() throws Exception {
        String task = " 4^3^5";
        assertEquals(pow(4, pow(3, 5)), script.parse(task), EPS);

        task = " 2^(3^5)";
        assertEquals(pow(2, pow(3, 5)), script.parse(task), EPS);

        task = "(5^3)^2";
        assertEquals(pow(pow(5, 3), 2), script.parse(task), EPS);
    }

    @Test
    public void testParsePowRnd() throws Exception {
        double x, y, z, expected, result;
        for (int j = 0; j<10; j++ ) {
            x = 4*rnd();
            y = 2*rnd();
            z = rnd();
            expected = pow(x, pow(y, z));
            script.setVariable("x", x);
            script.setVariable("y", y);
            script.setVariable("z", z);

            result = script.parse("x**y** z ");
            assertEquals(expected, result, EPS);
            result = script.parse("x^ y ^ z");
            assertEquals(expected, result, EPS);
            result = script.parse("x**y ^ z");
            assertEquals(expected, result, EPS);
            result = script.parse("x ^y **z");
            assertEquals(expected, result, EPS);
        }
    }

    @Test
    public final void testDefFunction() throws Exception {
        String task = "f(x,y)=3*x+y";
        script.parse(task);
        Function fct = script.getFunction("f");
        assertNotNull("no function found", fct);
    }

    @Test
    public final void testFunctionRedefinition() throws Exception {
        Function fct;
        double x = 4;
        String task = "a=3;b=2;";

        script.parse(task);

        task = "f(x)=a*x+b";
        script.parse(task);

        fct = script.getFunction("f");
        assertNotNull("no function found", fct);
        assertEquals(14.0, fct.eval(x), EPS);

        task = "f(x)=a*x-b";
        script.parse(task);
        fct = script.getFunction("f");
        assertNotNull("no redefined function found", fct);
        assertEquals(10.0, fct.eval(x), EPS);

    }

    @Test
    public final void testEvalFunction() throws Exception {
        String task;
        double x = 5*rnd();
        double a = 5*rnd();
        task = format("x=%.3f; f(z)=z*z + 2*z +1;  a=%.3f; y=f(a)", x, a);
        a += 1;
        assertEquals(a*a, script.parse(task), EPS);
        assertEquals(x, script.getVariable("x"), EPS);
        assertEquals(a*a, script.getVariable("y"), EPS);
        assertEquals(a-1, script.getVariable("a"), EPS);
    }

    @Test
    public final void testEvalFunctionLoop() throws Exception {
        String task;
        task = "x=1;f(x)=x*x + 4*x +2;y=f(3)";
        assertEquals(23, script.parse(task), EPS);
        assertEquals(23, script.getVariable("y"), EPS);
        Function fct = script.getFunction("f");
        for (double x = -4; x<=10; x += 0.2) {
            assertEquals(x*x+4*x+2, fct.eval(x), EPS);
        }
    }

    @Test
    public final void testEvalDefLoop() throws Exception {
        String task;
        double y;
        task = "f(x)=x*x - 4*x +3.2";
        script.parse(task);
        for (double x = -4; x<=10; x += 0.2) {
            task = format("x=%.3f; y=f(x)", x);
            y = script.parse(task);
            assertEquals(x*x-4*x+3.2, y, EPS);
        }

    }

    @Test(expected = IllegalArgumentException.class)
    public final void testEvalUnknownFunction() throws Exception {
        String task;
        task = "x=3;f(x)=x*x;y=h(x);";
        script.parse(task);
    }

    @Test
    public final void testEvalFunction2D() throws Exception {
        String task;
        task = "u=3; f(x,y)=x*y - x; y=f(u,3); x = f(y,4);";
        assertEquals(18.0, script.parse(task), EPS);
        assertEquals(3, script.getVariable("u"), EPS);
        assertEquals(6, script.getVariable("y"), EPS);
        assertEquals(18, script.getVariable("x"), EPS);
    }

    @Test
    public final void testEvalFunction3D() throws Exception {
        String task;
        double x = rnd(2), y = rnd(2);
        task = format("u=3; f(x,y,z)=x*y*z; x=%.3f; y=%.3f; y=f(x,x+y,u)", x, y);
        assertEquals(x*(x+y)*3, script.parse(task), EPS);
    }

    @Test
    public final void testEvalFunctionArgs() throws Exception {
        String task;
        double x = rnd(2), y = rnd(2), z = rnd(2);
        task = format("u=3; f(x,y,z)=x*y*z; y=f(%.3f+%.3f,%.3f,u)", x, y, z);
        assertEquals((x+y)*z*3, script.parse(task), EPS);
    }

    @Test
    public final void testEvalMixedFunction() throws Exception {
        String task;
        task = "h(x)=x*2; y=h(4); f(x,y)=x*y; y=f(3,y);";
        assertEquals(24, script.parse(task), EPS);
    }

    @Test
    public final void testEvalFunctionTwice() throws Exception {
        String task;
        task = "z=4; h(x)=x*2; x=h(5); y=h(z); ";
        assertEquals(8, script.parse(task), EPS);
    }

    @Test
    public final void testEvalPowerFunctions() throws Exception {
        String task;
        task = "z=4; h(x)=x**2; f(q)=q*q; y=h(z)+f(z);";
        assertEquals(32, script.parse(task), EPS);
    }

    @Test
    public final void testFunction() throws Exception {
        String task = "h(x,y)=x**y; f(x)=3*x; foo(x,a,c)=c*x**a";
        Function fct;
        double a = 2;
        script.parse(task);
        fct = script.getFunction("h");
        assertEquals(8.0, fct.eval(a, 3), EPS);
        assertEquals(9.0, fct.eval(3, 2), EPS);
        fct = script.getFunction("f");
        assertEquals(6.0, fct.eval(a), EPS);
        fct = script.getFunction("foo");
        assertEquals(4*Math.pow(a, 3), fct.eval(a, 1+2, 4), EPS);
        // also further script definitions are possible
        task = "u=2; b=4; q=5; y = foo(u,b,q);";
        assertEquals(5*Math.pow(2, 4), script.parse(task), EPS);
    }

    @Test
    public final void testSavedArgumentsAfterFunction() throws Exception {
        String task = "x=3; y=2; h(x,y)=x*y; z = h(5,7)";
        assertEquals(35, script.parse(task), EPS);
        assertEquals(3.0, script.getVariable("x"), EPS);
        assertEquals(2.0, script.getVariable("y"), EPS);
    }

    @Test
    public final void testSavedArgumentsAfterFunctionCall() throws Exception {
        Function fct;
        String task = "x=3; h(x,y)=x/y; a=5; z = h(a,x)";
        double z = script.parse(task);
        assertEquals(5./3., z, EPS);
        fct = script.getFunction("h");
        assertEquals(7./5., fct.eval(7, 5), EPS);
        assertEquals(5.0, script.getVariable("a"), EPS);
        assertEquals(3.0, script.getVariable("x"), EPS);
    }

    @Test(expected = IllegalArgumentException.class)
    public final void testGetUnknownFunction() throws Exception {
        String task = "x=3;f(x)=x*x;";
        script.parse(task);
        script.getFunction("h");
    }

    @Test
    public final void testIndependendScripts() throws Exception {
        String task1 = "a = 5; f(y)=y*y";
        String task2 = "a = 4; f(z)=2*z";
        Script script1 = script, script2 = getScript();
        assertTrue("scripts not independend", script1!=script2);
        assertNotSame("scripts are equal", script1, script2);
        script.parse(task1);
        script2.parse(task2);
        assertEquals(25.0, script1.getFunction("f").eval(script1.getVariable("a")), EPS);
        assertEquals(08.0, script2.getFunction("f").eval(script2.getVariable("a")), EPS);
        assertEquals(16.0, script1.getFunction("f").eval(script2.getVariable("a")), EPS);
        assertEquals(10.0, script2.getFunction("f").eval(script1.getVariable("a")), EPS);
    }

    @Test
    public final void testConcatScripts() throws Exception {
        String task1 = "a = 5; f(y)=y*y";
        String task2 = "a = 4; f(z)=2*z";
        Script script1 = script, script2 = getScript(), script3;
        assertTrue("scripts not independend", script1!=script2);
        assertNotSame("scripts are equal", script1, script2);
        script.parse(task1);
        script2.parse(task2);
        assertEquals(25.0, script1.getFunction("f").eval(script1.getVariable("a")), EPS);
        assertEquals(08.0, script2.getFunction("f").eval(script2.getVariable("a")), EPS);
        assertEquals(16.0, script1.getFunction("f").eval(script2.getVariable("a")), EPS);
        assertEquals(10.0, script2.getFunction("f").eval(script1.getVariable("a")), EPS);
        script3 = script.concat(script2);

        assertEquals(script2.getVariable("a"), script3.getVariable("a"), EPS);
        assertEquals(08.0, script3.getFunction("f").eval(script3.getVariable("a")), EPS);
    }

    @Test
    public final void testConcatScriptsIndependent() throws Exception {
        String task1 = "a = 5; f(y)=y*y; g(w)=w";
        String task2 = "a = 4; f(z)=3*z";
        Script script1 = script, script2 = getScript(), script3;
        assertTrue("scripts not independend", script1!=script2);
        assertNotSame("scripts are equal", script1, script2);
        script.parse(task1);
        script2.parse(task2);

        script3 = script1.concat(script2);
        assertTrue("scripts not independend concatenated ", script1!=script3);
        assertNotSame("scripts are equal", script1, script3);

        assertTrue("scripts not independend concatenated", script2!=script3);
        assertNotSame("scripts are equal", script2, script3);

        assertEquals(25.0, script1.getFunction("f").eval(script1.getVariable("a")), EPS);
        assertEquals(script2.getVariable("a"), script3.getVariable("a"), EPS);
        assertEquals(04.0, script3.getFunction("g").eval(script3.getVariable("a")), EPS);
        assertEquals(12.0, script3.getFunction("f").eval(script3.getVariable("a")), EPS);
    }

    @Test
    public final void testEvalInputStream() throws Exception {
        String task = "z=4; h(x)=x**2; f(q)=q*q; y=h(z)+f(z);";
        InputStream stream = new ByteArrayInputStream(task.getBytes());
        assertEquals(32, script.parse(stream), EPS);
        Function f = script.getFunction("h");
        assertEquals(9.0, f.eval(3), EPS);
    }

    @Test
    public final void testFunctionFromStream() throws Exception {
        String task = "h(x,y)=x**y;";
        InputStream stream = new ByteArrayInputStream(task.getBytes());
        script.parse(stream);
        Function f = script.getFunction("h");
        assertEquals(8.0, f.eval(2, 3), EPS);
        assertEquals(9.0, f.eval(3, 2), EPS);
    }

    @Test
    public final void testMax() throws Exception {
        double x, y;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = rnd();
            y = x+1;
            script.setVariable("x", x);
            script.setVariable("y", y);
            if (j%2==0)
                task = "max(y,x)";
            else
                task = "max(x,y)";
            assertEquals(y, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMin() throws Exception {
        double x, y;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = rnd();
            y = x+1;
            script.setVariable("x", x);
            script.setVariable("y", y);
            if (j%2==0)
                task = "min(y,x)";
            else
                task = "min(x,y)";
            assertEquals(x, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMin3Args() throws Exception {
        double x, y, z;
        String task;
        for (int j = 0; j<18; j++ ) {
            x = rnd();
            y = x+1;
            z = 4*y;
            script.setVariable("x", x);
            script.setVariable("y", y);
            script.setVariable("z", z);
            if (j%3==0)
                task = "min(y,x,z)";
            else if (j%3==1)
                task = "min(y,z,x)";
            else
                task = "min(x,y,z)";
            assertEquals(x, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMax4Args() throws Exception {
        double x, y, z, u;
        String task;
        for (int j = 0; j<20; j++ ) {
            x = rnd();
            y = x+1;
            z = 4*y;
            u = 2*y;
            script.setVariable("x", x);
            script.setVariable("y", y);
            script.setVariable("z", z);
            script.setVariable("u", u);
            if (j%4==0)
                task = "max(y,x,z,u)";
            else if (j%4==1)
                task = "max(y,z,u,x)";
            else if (j%4==2)
                task = "max(y,u,z,x)";
            else
                task = "max(u,x,y,z)";

            assertEquals(z, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMin4Args() throws Exception {
        double x, y, z, u;
        String task;
        for (int j = 0; j<20; j++ ) {
            x = rnd();
            y = x+1;
            z = 4*y;
            u = 2*y;
            script.setVariable("x", x);
            script.setVariable("y", y);
            script.setVariable("z", z);
            script.setVariable("u", u);
            if (j%4==0)
                task = "min(y,x,z,u)";
            else if (j%4==1)
                task = "min(y,z,u,x)";
            else if (j%4==2)
                task = "min(y,u,z,x)";
            else
                task = "min(u,x,y,z)";
            assertEquals(x, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathAbs() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "abs(x)";
            assertEquals(abs(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathSqrt() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random();
            script.setVariable("x", x);
            task = "sqrt(x)";
            assertEquals(sqrt(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathSinh() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random();
            script.setVariable("x", x);
            task = "sinh(x)";
            assertEquals(sinh(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathCosh() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random();
            script.setVariable("x", x);
            task = "cosh(x)";
            assertEquals(cosh(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathSin() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "sin(x)";
            assertEquals(sin(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathCos() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "cos(x)";
            assertEquals(cos(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathTan() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "tan(x)";
            assertEquals(tan(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathArcSin() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 2*Math.random()-1;
            script.setVariable("x", x);
            task = "asin(x)";
            assertEquals(asin(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathArcCos() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 2*Math.random()-1;
            script.setVariable("x", x);
            task = "acos(x)";
            assertEquals(acos(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathArcTan() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "atan(x)";
            assertEquals(atan(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathExp() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            script.setVariable("x", x);
            task = "exp(x)";
            assertEquals(exp(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathLn() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "ln(x)";
            assertEquals(log(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathLogE() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "logE(x)";
            assertEquals(log(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathLog10() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "log10(x)";
            assertEquals(log10(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathAliasLog10() throws Exception {
        double x;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "log(x)";
            assertEquals(log10(x), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathLog2() throws Exception {
        double x, ln2 = log(2);
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "log2(x)";
            assertEquals(log(x)/ln2, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathAlias1Lb() throws Exception {
        double x, ln2 = log(2);
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "lb(x)";
            assertEquals(log(x)/ln2, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathAliasld() throws Exception {
        double x, ln2 = log(2);
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 0.1+Math.random();
            script.setVariable("x", x);
            task = "ld(x)";
            assertEquals(log(x)/ln2, script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathPow() throws Exception {
        double x, y;
        String task;
        for (int j = 0; j<10; j++ ) {
            x = 10*Math.random()-5;
            y = 10*Math.random()-5;
            script.setVariable("x", x);
            script.setVariable("y", y);
            task = "pow(x,y)";
            assertEquals(pow(x, y), script.parse(task), EPS);
        }
    }

    @Test
    public final void testMathCircle() throws Exception {
        double x;
        String task = "one(x)=sin(x)**2 + cos(x)^2;";
        script.parse(task);
        Function one = script.getFunction("one");
        for (int j = 0; j<100; j++ ) {
            x = rnd();
            assertEquals(1.0, one.eval(x), EPS);
        }
    }

    @Test
    public final void testMathIdSinArcSin() throws Exception {
        double x;
        String task = "idsin(x)=asin(sin(x));";
        script.parse(task);
        Function is = script.getFunction("idsin");
        for (int j = 0; j<100; j++ ) {
            // test positive values
            x = random();
            assertEquals(x, is.eval(x), EPS);
            // test negative values
            x = -x;
            assertEquals(x, is.eval(x), EPS);
        }
    }

    @Test
    public final void testMathIdCosArcCos() throws Exception {
        double x;
        String task = "idcos(x)=acos(cos(x));";
        script.parse(task);
        Function ic = script.getFunction("idcos");
        for (int j = 0; j<100; j++ ) {
            // test positive values
            x = random();
            assertEquals(x, ic.eval(x), EPS);
            // test negative values
            x = -x;
            assertEquals( -x, ic.eval(x), EPS);
        }
    }

    @Test
    public final void testMathIdTanArcTan() throws Exception {
        double x;
        String task = "idtan(x)=atan(tan(x));";
        script.parse(task);
        Function it = script.getFunction("idtan");
        for (int j = 0; j<100; j++ ) {
            // test positive values
            x = random();
            assertEquals(x, it.eval(x), EPS);
            // test negative values
            x = -x;
            assertEquals(x, it.eval(x), EPS);
        }
    }

    @Test
    public final void testMathMixedFunctions() throws Exception {
        double x;
        String task = "s(x)=sin(x); g(a)=cos(a)*tan(a);"+" h(z)=z*s(z);";
        script.parse(task);
        Function h = script.getFunction("h");
        Function g = script.getFunction("g");
        for (int j = 0; j<100; j++ ) {
            // random in interval [-5,5]
            x = 10*random()-5;
            assertEquals(x*sin(x), h.eval(x), EPS);
            assertEquals(cos(x)*tan(x), g.eval(x), EPS);
        }
    }

    @Test
    public void testEvalFctFromFct() throws Exception {
        String task;
        task = "h(x)=x*x;f(x)=h(x);f(3);";
        assertEquals(9, script.parse(task), EPS);
    }

    @Test
    public void testEvalFromTwoFunctions() throws Exception {
        String task;
        task = "z=4;h(x)=x^2;f(x)=x*x;y(z)=h(z)+f(z);q=y(z);";
        assertEquals(2*4*4, script.parse(task), EPS);
    }

    @Test
    public void testConvolutetFunctions() throws Exception {
        String task;
        task = "z=7; h(x)=x*5; f(x)=x*x; y(z)=h(f(z)); q=y(z);";
        assertEquals(5*7*7, script.parse(task), EPS);
    }

    /**
     * Generic test method to check if an object can be serialised.
     * 
     * @param testee  the object to be serialised
     * @throws Exception  in case of an error
     */
    protected <T extends Serializable> Object executeSerializableTest(T testee) throws Exception {
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        Object deserialised = null;
        File f = File.createTempFile("Junit", ".ser");
        f.deleteOnExit();
        try {
            out = new ObjectOutputStream(new FileOutputStream(f));
            out.writeObject(testee);
        } finally {
            if (null!=out)
                out.close();
        }
        try {
            in = new ObjectInputStream(new FileInputStream(f));
            deserialised = in.readObject();
        } finally {
            if (null!=in)
                in.close();
        }
        Assert.assertEquals(testee, deserialised);
        return deserialised;
    }

    /**
     * Test that the function is not parsed within every single call. The string
     * definition has to be parsed one time and the syntax tree has to be
     * cached, otherwise numerical integration of parsed functions becomes very
     * cumbersome and nearly impossible.
     * 
     * Note:  THIS TEST MUST NOT FAIL FOR AN ABTESTAT!
     * 
     * @throws Exception
     */
    @Test
    public void testTimingCachedFunctions() throws Exception {
        final String fmt = "\n\n"+"  Parser Timing Test    \n"+"=====================    \n"
                +"cached :%6d \u03BCs/call  \n"+"parsed :%6d \u03BCs/call  \n"+"speedup: %.2f => %s  \n\n";
        final int MAX_PARSE_TIME = 1000;
        final int MAX_LOOPS = 5000;
        final double SCALED = -1000*MAX_LOOPS;
        double speedup, x = 0.1;
        long timeParsed, timeCached;
        String task;
        // sine function Taylor expansion will produce some performance burden.
        task = "a1=1;a3=-1/6;a5=1/120; a7=-1/5040; a0=0;a2=0;a4=0;a6=0;a8=0;"
                +"s(x)=a0+a1*x+a2*x*x+a3*x^3+a4*x^4+a5*x^5+a6*x^6+a7*x^7+a8*x^8; err(x) = s(x) - sin(x);";
        script.parse(task);
        Function fct = script.getFunction("err");
        // first check that the parsing is correct
        for (x = -0.8; x<=0.8; x += 0.001) {
            script.setVariable("x", x);
            assertEquals(format("error(%.2f) to large: %.3g", x, fct.eval(x)), 0.0, fct.eval(x), 100*EPS);
        }
        // second check that the parsing is correct
        fct = script.getFunction("s");
        for (x = -0.8; x<=0.8; x += 0.001) {
            script.setVariable("x", x);
            assertEquals(format("error(%.2f) to large: %.3g", x, fct.eval(x)), Math.sin(x), fct.eval(x), 100*EPS);
        }

        // now calculate the timing; knowing the calculations are correct
        timeCached = System.nanoTime();
        x = rnd()/2;
        for (int k = 0; k<MAX_LOOPS; k++ ) {
            fct.eval(x);
        }
        timeCached -= System.nanoTime();

        timeParsed = System.nanoTime();
        for (int k = 0; k<MAX_LOOPS; k++ ) {
            script.parse(task);
        }
        timeParsed -= System.nanoTime();

        speedup = (timeParsed)/timeCached;
        timeParsed /= SCALED;
        timeCached /= SCALED;

        assertTrue(format("parsing too slow %d \u03BCs/call", timeParsed), timeParsed<MAX_PARSE_TIME);

        String rating = "failed ";
        if (speedup>9) {
            rating = "passed excellent";
        } else if (speedup>6) {
            rating = "passed ok";
        } else if (speedup>3) {
            rating = "passed but poor";
        }
        System.err.printf(format(fmt, timeCached, timeParsed, speedup, rating));

        assertTrue("function syntax tree not cached", speedup>3);
    }

}
