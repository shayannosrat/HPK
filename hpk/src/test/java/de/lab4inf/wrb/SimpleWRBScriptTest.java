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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

/**
 * Test of the Wulff RunsBeta-Script language.
 * 
 * @author nwulff
 * @since 16.10.2013
 * @version $Id: SimpleWRBScriptTest.java,v 1.3 2017/10/05 22:13:09 nwulff Exp $
 */
public class SimpleWRBScriptTest {
    final double eps = 1.E-8;
    Script script;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public final void setUp() throws Exception {
        script = getScript();
        assertNotNull("no script implementation", script);
    }

    /**
     * Get the actual implementation for the script test.
     * 
     * @return script implementation
     */
    protected Script getScript() {
        return new WRBScript();
    }

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
        double y, x = 2.78;
        String key = "XYZ";
        script.setVariable(key, x);
        y = script.getVariable(key);
        assertEquals(x, y, eps);
        x = Math.random();
        script.setVariable(key, x);
        y = script.getVariable(key);
        assertEquals(x, y, eps);
    }

    /**
     * Test method for {@link de.lab4inf.wrb.Script#parse(java.lang.String)}.
     * Testing some very simple operation. More to come...
     */

    @Test
    public final void testPlus() throws Exception {
        String task = "2+3";
        assertEquals(5.0, script.parse(task), eps);
    }

    @Test
    public final void testMinus() throws Exception {
        String task = "2 - 6";
        assertEquals(-4.0, script.parse(task), eps);
    }

    @Test
    public final void testConstant() throws Exception {
        String task = "0815; 4711";
        assertEquals(4711.0, script.parse(task), eps);
    }

    @Test
    public final void testSigned() throws Exception {
        String task = "-2 + 6";
        assertEquals(4.0, script.parse(task), eps);
    }

    @Test
    public void testSignedSecondArg() throws Exception {
        String task = "2 + -6";
        assertEquals(-4.0, script.parse(task), eps);
    }

    @Test
    public final void testMixedFloat() throws Exception {
        String task = "2.0/3 - 5.2*4";
        assertEquals(2. / 3.0 - 5.2 * 4, script.parse(task), eps);
    }

    @Test
    public final void testLongAdd() throws Exception {
        String task = "2.0 + 3 + 4.0 + 5";
        assertEquals(14, script.parse(task), eps);
    }

    @Test
    public final void testLongMult() throws Exception {
        String task = "2 * 3.0 * 4 * 5.000";
        assertEquals(120, script.parse(task), eps);
    }

    @Test
    public final void testLongMixed() throws Exception {
        String task = "2.0 * 3 * 4.0 + 5 + 6.0 / 3 ";
        assertEquals(31, script.parse(task), eps);
    }

    @Test
    public void testParseBracket() throws Exception {
        String task = " 2*(4.0 + 3)";
        assertEquals(14, script.parse(task), eps);
    }
}
