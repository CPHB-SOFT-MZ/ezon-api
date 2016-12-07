/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.sorters;

import java.util.ArrayList;
import java.util.Collections;
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
 * @author kaspe
 */
public class SortByPriceTest {
    
    public SortByPriceTest() {
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
     * Test of compare method, of class SortByPrice.
     */
    @Test
    public void testSorting() {
        System.out.println("compare");
        List products = new ArrayList();
        List productsResult = new ArrayList();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setPrice("2");
        p2.setPrice("2.23");
        p3.setPrice("2.32213");
        p4.setPrice("22");
        productsResult.add(p1);
        productsResult.add(p2);
        productsResult.add(p3);
        productsResult.add(p4);
        products.add(p1);
        products.add(p3);
        products.add(p4);
        products.add(p2);
        Collections.sort(products, new SortByPrice());
        assertArrayEquals(productsResult.toArray(), products.toArray());
    }
    
    @Test
    public void testSortingWithCommas() {
        System.out.println("compare");
        List products = new ArrayList();
        List productsResult = new ArrayList();
        Product p1 = new Product();
        Product p2 = new Product();
        Product p3 = new Product();
        Product p4 = new Product();
        p1.setPrice("2");
        p2.setPrice("2,23");
        p3.setPrice("2.32213");
        p4.setPrice("22");
        productsResult.add(p1);
        productsResult.add(p2);
        productsResult.add(p3);
        productsResult.add(p4);
        products.add(p1);
        products.add(p3);
        products.add(p4);
        products.add(p2);
        Collections.sort(products, new SortByPrice());
        assertArrayEquals(productsResult.toArray(), products.toArray());
    }
    
}
