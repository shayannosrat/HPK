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

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Common interface for the WRB parsing service. A script allows to define and 
 * hold variables,functions and mathematical expressions within its context.
 * The working horse is the parse method, which transforms the definition 
 * into an internal representation for quick access to functions and variables.
 *  
 * Note: all script methods can and should throw IllegalArgumentException
 * in case of internal errors like wrong arguments, definitions or names. 
 * E.g ANTLR exceptions are not allowed to pollute the script API.  
 *  
 * New: Since JDK1.8 scripts can be concatenated via a default method. 
 * 
 * @author  nwulff
 * @since   29.10.2013
 * @version $Id: Script.java,v 1.3 2017/10/05 11:23:36 nwulff Exp $
 */
public interface Script {
    /**
     * Parse the given String into an internal representation (e.g. as AST) and
     * evaluate the expression(s).
     * @param definition of the script expression(s) as a String
     * @return the result of the parsed evaluation
     */
    double parse(String definition);

    /**
     * Parse the InputStream into an internal representation (e.g. as AST) and
     * evaluate the expression(s).
     * @param defStream of the script expression(s) as InputStream
     * @return the result of the parsed evaluation
     * @throws IOException in case of a stream I/O error
     */
    double parse(InputStream defStream) throws IOException;

    /**
     * Get all script known function names.
     * @return set with the function names
     */
    Set<String> getFunctionNames();

    /**
     * Get all script known variable names.
     * @return set with the variables names
     */
    Set<String> getVariableNames();

    /**
     * Add a named function to this script.
     * @param name of the function to be unique
     * @param fct to add 
     */
    void setFunction(String name, Function fct);

    /**
     * Get a (unique!) named function.
     * @param name of the function
     * @return an implementation
     */
    Function getFunction(String name);

    /**
     * Get the value of a (unique!) named variable.
     * @param name of the variable
     * @return the actual variable value
     */
    double getVariable(String name);

    /**
     * Set the value of a named variable.
     * @param name of the variable to be unique
     * @param value the new variable setting
     */
    void setVariable(String name, double value);

    /**
     * New default method since JDK 1.8!
     * Concatenation of "this" script with "that" script. This
     * default implementation simply adds the context of the other
     * script, which means it may overwrite the internal script state.
     * 
     * Implementing script classes should change this behaviour to 
     * construct a new fresh script merged from "this" and "that" as return
     * without changing the internal state of "this" and "that".
     *   
     * @param that another script with variables and functions to add
     * @return the (optional new)) build script.
     */
    default Script concat(Script that) {
        // old fashion JDK 1.5 for-loop
        for (String varName : that.getVariableNames()) {
            double var = that.getVariable(varName);
            this.setVariable(varName, var);
        }
        // new style for-each-loop with lambda expression
        that.getFunctionNames().forEach((fctName) -> {
            setFunction(fctName, that.getFunction(fctName));
        });
        return this;
    }
}
