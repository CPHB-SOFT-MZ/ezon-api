/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mikkel
 */
public class SpaceFormatterTest {
    
    public SpaceFormatterTest() {
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
     * Test of format method, of class SpaceFormatter.
     */
    @Test
    public void testFormat() {
        System.out.println("format");
        String stringToFormat = "  Macbook pro    ";
        String expResult = "Macbook+pro";
        
        String result = SpaceFormatter.format(stringToFormat);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
}
