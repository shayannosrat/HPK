/*
 * Project: HPK
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

import java.util.logging.Logger;

/**
 * Native WRB Integrator.
 * 
 * @author  nwulff
 * @since   26.11.2013
 * @version $Id: Integrator.java,v 1.4 2017/12/02 15:47:22 nwulff Exp $
 */
public class Integrator {
    static final Logger logger = java.util.logging.Logger.getLogger("de.lab4inf");
    private double eps = 1.E-9;
    static {
        try {
            // String libName = "HPK-CPP";
            String libName = "WRB4";
            System.loadLibrary(libName);
        } catch (Throwable error) {
            logger.severe("LibPath: " + System.getProperty("java.library.path"));
            logger.severe("native lib loading failed " + error);
            System.exit(-1);
        }
    }

    /**
     * Integrate the function f from a to b. 
     * @param f function to differentiate.
     * @param a lower border
     * @param b upper border
     * @param eps precission to reach
     * @return F(b)-F(a) 
     */
    public double integrate(Function f, double a, double b) {
        return integrate(f, a, b, eps);
    }

    /**
     * Integrate the function f from a to b. 
     * @param f function to differentiate.
     * @param a lower border
     * @param b upper border
     * @param eps precission to reach
     * @return F(b)-F(a) 
     */
    public native double integrate(Function f, double a, double b, double eps);

    /**
     * Get the value of eps.
     * @return the eps
     */
    public double getEps() {
        return eps;
    }

    /**
     * Set the eps attribute.
     * @param eps the eps to set
     */
    public void setEps(double eps) {
        this.eps = eps;
    }

}
