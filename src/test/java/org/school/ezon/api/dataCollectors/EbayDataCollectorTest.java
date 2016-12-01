/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author kaspe
 */
public class EbayDataCollectorTest {
    
    public EbayDataCollectorTest() {
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
     * Test of getProductsFromCategory method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsFromCategory() {
        System.out.println("Test that we get a list that is not empty from eBay with a given category");
        String category = "cars";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        EbayDataFormatter instance = new EbayDataFormatter(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsFromCategory(category);
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getProductsBySearch method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearch() {
        System.out.println("Test that we get a list that is not empty from eBay with a search String");
        String searchString = "Macbook";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        EbayDataFormatter instance = new EbayDataFormatter(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsBySearch(searchString);
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getProductsBySearchAndCategory method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("Test that we get a list that is not empty from eBay with category and search word");
        String category = "cars";
        String searchString = "Macbook";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        EbayDataFormatter instance = new EbayDataFormatter(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsBySearchAndCategory(category, searchString);
        assertTrue(!result.isEmpty());
    }
    
}
