/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilab;

import org.testng.annotations.Test;

/**
 *
 * @author chrismkhontwana
 */
public class ILabNGTest extends SeleniumActions{
    
    public ILabNGTest() {
    }
    /**
     * Test of ApplyOnline method, of class ILab.
     */
    @Test
    public void testApplyOnline() {
        System.out.println("ApplyOnline test case is started......");
        startTesting("Apply to iLab online");
        ILab instance = new ILab();
        instance.ApplyOnline();
         shutDownBrowser();
    }
    
}
