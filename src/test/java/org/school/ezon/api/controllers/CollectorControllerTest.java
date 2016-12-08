/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class CollectorControllerTest {
    
    public CollectorControllerTest() {
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
     * Test of getProductsBySearchAndCategory method, of class CollectorController.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("getProductsBySearchAndCategory");
        
        String searchString = "audi";
        String category = "vehiclesandaccess";
        List<Product> products = new ArrayList();
        DataCollector dataCollector = mock(DataCollector.class);
        List<DataCollector> dataCollectors = new ArrayList();
        dataCollectors.add(dataCollector);
        
        CollectorController instance = new CollectorController(dataCollectors);
        when(dataCollector.getProductsBySearchAndCategory(category, searchString)).thenReturn(products);
        when(dataCollector.getDataCollectorID()).thenReturn("ebay");
        List<Product> result = instance.getProductsBySearchAndCategory(category, searchString);
        assertEquals(products, result);
    }

    /**
     * Test of getProductsBySearch method, of class CollectorController.
     */
    @Test
    public void testGetProductsBySearch() {
        System.out.println("getProductsBySearch");
        
        String searchString = "audi";
        List<Product> products = new ArrayList();
        DataCollector dataCollector = mock(DataCollector.class);
        List<DataCollector> dataCollectors = new ArrayList();
        dataCollectors.add(dataCollector);
        
        CollectorController instance = new CollectorController(dataCollectors);
        when(dataCollector.getProductsBySearch(searchString)).thenReturn(products);
        
        List<Product> result = instance.getProductsBySearch(searchString);
        assertEquals(products, result);
    }

    /**
     * Test of getProductsFromCategory method, of class CollectorController.
     */
    @Test
    public void testGetProductsFromCategory() {
        System.out.println("getProductsBySearchAndCategory");
        
        String category = "hobby";
        List<Product> products = new ArrayList();
        DataCollector dataCollector = mock(DataCollector.class);
        List<DataCollector> dataCollectors = new ArrayList();
        dataCollectors.add(dataCollector);
        
        CollectorController instance = new CollectorController(dataCollectors);
        when(dataCollector.getProductsFromCategory(category)).thenReturn(products);
        when(dataCollector.getDataCollectorID()).thenReturn("dba");
        List<Product> result = instance.getProductsFromCategory(category);
        assertEquals(products, result);
    }
    
}
