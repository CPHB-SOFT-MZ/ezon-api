/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author philliphbrink
 */
public class IntergrationEbayDataCollectorTest {
    
    public IntergrationEbayDataCollectorTest() {
    }

    /**
     * Test of getProductsFromCategory method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsFromCategory() {
        System.out.println("getProductsFromCategory");
        String category = "";
        EbayDataCollector instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsFromCategory(category);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductsBySearch method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearch() {
        System.out.println("getProductsBySearch");
        String searchString = "";
        EbayDataCollector instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsBySearch(searchString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductsBySearchAndCategory method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("getProductsBySearchAndCategory");
        String category = "";
        String searchString = "";
        EbayDataCollector instance = null;
        List<Product> expResult = null;
        List<Product> result = instance.getProductsBySearchAndCategory(category, searchString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
