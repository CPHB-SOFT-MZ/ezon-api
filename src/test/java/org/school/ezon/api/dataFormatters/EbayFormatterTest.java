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
import org.school.ezon.api.dataCollectors.EbayDataCollector;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author danie
 */
public class EbayFormatterTest {

    EBAYFormatter ebayFormatter;
    EbayDataCollector ebayCollector;

    public EbayFormatterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ebayFormatter = new EBAYFormatter();
        ebayCollector = new EbayDataCollector(ebayFormatter);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of formatProducts method, of class EBAYFormatter.
     */
    @Test
    public void testFormatProducts() {

        List<Product> products = ebayCollector.getProductsBySearchAndCategory("1", "ball");

        assertTrue(products.size() > 1);

        for (Product p : products) {
            assertNotNull(p.getTitle());
            assertNotNull(p.getDescription());
            assertNotNull(p.getThumbnailImage());
            assertNotNull(p.getSite());
            assertNotNull(p.getPrice());
            assertNotNull(p.getUrl());
        }
    }

    /**
     * Test of main method, of class EBAYFormatter.
     */
    @Test
    public void testMain() {
    }

}
