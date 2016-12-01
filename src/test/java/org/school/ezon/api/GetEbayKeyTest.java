/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author philliphbrink
 */
public class GetEbayKeyTest {
    
    public GetEbayKeyTest() {
    }

    /**
     * Test of fetchKey method, of class GetEbayKey.
     */
    @Test
    public void testFetchKey() {
        System.out.println("fetchKey");
        GetEbayKey instance = new GetEbayKey();
        instance.fetchKey();
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKey method, of class GetEbayKey.
     */
    @Test
    public void testGetKey() {
        System.out.println("getKey");
        GetEbayKey instance = new GetEbayKey();
        String expResult = "";
        String result = instance.getKey();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class GetEbayKey.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        GetEbayKey instance = new GetEbayKey();
        instance.run();
        fail("The test case is a prototype.");
    }
    
}
