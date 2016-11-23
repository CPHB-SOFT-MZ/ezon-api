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
public class DBADataCollectorTest {
    
    public DBADataCollectorTest() {
    }

    /**
     * Test of getProductsFromCategory method, of class DBADataCollector.
     */
//    @Test
//    public void testGetProductsFromCategory() {
//        System.out.println("getProductsFromCategory");
//        String category = "";
//        DBADataCollector instance = new DBADataCollector();
//        List<Product> expResult = null;
//        List<Product> result = instance.getProductsFromCategory(category);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getProductsBySearch method, of class DBADataCollector.
//     */
//    @Test
//    public void testGetProductsBySearch() {
//        System.out.println("getProductsBySearch");
//        String searchString = "";
//        DBADataCollector instance = new DBADataCollector();
//        List<Product> expResult = null;
//        List<Product> result = instance.getProductsBySearch(searchString);
//        assertEquals(expResult, result);
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getProductsBySearchAndCategory method, of class DBADataCollector.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("Test that we get a list that is not empty from DBA with category and search word");
        String category = "1";
        String searchString = "audi";
        DBADataCollector instance = new DBADataCollector();
        List<Product> result = instance.getProductsBySearchAndCategory(category, searchString);
        assertTrue(!result.isEmpty());
    }
    
}
