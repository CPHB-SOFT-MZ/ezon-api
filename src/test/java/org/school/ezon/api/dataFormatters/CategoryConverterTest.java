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
//    @Test
//    public void testConvertCategoryToDestination() {
//        System.out.println("convertCategoryToDestination");
//        String category = "vehiclesandaccess";
//        String destination = "dba";
//        String[] expResult = ;
//        String result[] = instance.convertCategoryToDestination(category, destination);
//        assertEquals(expResult, result);
//    }
    /**
     * Test of convert
     */
    @Test
    public void testConvertCategoryToDestination() {
        System.out.println("convertCategory");
        String category = "vehiclesandaccess";
        String destination = "dba";
        String[] expResult = new String[]{"1", "30", "8", "20", "11", "46"};
        String[] result = CategoryConverter.convertCategoryToDestination(category, destination);
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testReverseCategory() {
        System.out.println("Reversed mofo");
        String expRes = "hobby";

        String result = CategoryConverter.convertFromValue("36", "dba");
        String result1 = CategoryConverter.convertFromValue("25", "dba");
        String result2 = CategoryConverter.convertFromValue("260", "ebay");
        String result3 = CategoryConverter.convertFromValue("220", "ebay");

        assertEquals(expRes, result);
        assertEquals(expRes, result1);
        assertEquals(expRes, result2);
        assertEquals(expRes, result3);
    }

}
