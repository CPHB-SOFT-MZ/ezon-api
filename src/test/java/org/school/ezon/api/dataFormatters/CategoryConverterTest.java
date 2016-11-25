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
public class CategoryConverterTest {
    
    public CategoryConverterTest() {
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
     * Test of ConvertCategoryToDestination method, of class CategoryConverter.
     */
    @Test
    public void testConvertCategoryToDestination() {
        System.out.println("convertCategoryToDestination");
        String category = "cars";
        String destination = "amazon";
        CategoryConverter instance = new CategoryConverter();
        String expResult = "248878031";
        String result = instance.convertCategoryToDestination(category, destination);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    /**
     * Test of convert
     */
    @Test
    public void testConvertCategory(){
        System.out.println("convertCategory");
        String category = "cars";
        String destination = "dba";
        CategoryConverter instance = new CategoryConverter();
        String expResult = "1";
        String result = instance.convertCategory(category).get(destination);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReverseCategory(){
        System.out.println("Reversed mofo");
        String expRes = "hobby";
        
        String result = CategoryConverter.convertFromValue("36", "dba");
        
        assertEquals(expRes, result);
    }
    
}
