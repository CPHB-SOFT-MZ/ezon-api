/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.school.ezon.api.dataFormatters.DataFormatter;
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
    @Test
    public void testGetProductsFromCategory() {
        System.out.println("Test that we get a list that is not empty from DBA with a given category");
        String category = "1";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        DBADataCollector instance = new DBADataCollector(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsFromCategory(category);
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getProductsBySearch method, of class DBADataCollector.
     */
    @Test
    public void testGetProductsBySearch() {
        System.out.println("Test that we get a list that is not empty from DBA with a search String");
        String searchString = "audi";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        DBADataCollector instance = new DBADataCollector(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsBySearch(searchString);
        assertTrue(!result.isEmpty());
    }

    /**
     * Test of getProductsBySearchAndCategory method, of class DBADataCollector.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("Test that we get a list that is not empty from DBA with category and search word");
        String category = "1";
        String searchString = "audi";
        DataFormatter df = Mockito.mock(DataFormatter.class);
        DBADataCollector instance = new DBADataCollector(df);
        List<Product> products = new ArrayList();
        products.add(new Product());
        Mockito.when(df.formatProducts(Mockito.anyString())).thenReturn(products);
        List<Product> result = instance.getProductsBySearchAndCategory(category, searchString);
        assertTrue(!result.isEmpty());
    }

}
