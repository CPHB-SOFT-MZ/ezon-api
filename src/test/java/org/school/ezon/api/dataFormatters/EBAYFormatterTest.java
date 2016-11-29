/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author danie
 */
public class EBAYFormatterTest {
    
    public EBAYFormatterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of formatProducts method, of class EBAYFormatter.
     */
    @Test
    public void testFormatProducts() {
        System.out.println("formatProducts");
        String jsonFormat = "";
        EBAYFormatter instance = new EBAYFormatter();
        List<Product> expResult = null;
        List<Product> result = instance.formatProducts(jsonFormat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
