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
import org.school.ezon.api.dataCollectors.DBADataCollector;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author danie
 */
public class DBAFormatterTest {

    DBAFormatter dbaFormatter;
    DBADataCollector dbaDataCollector;

    public DBAFormatterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dbaFormatter = new DBAFormatter();
        dbaDataCollector = new DBADataCollector(dbaFormatter);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of formatProducts method, of class DBAFormatter.
     */
    @Test
    public void testFormatProducts() {

        List<Product> products = dbaDataCollector.getProductsBySearchAndCategory("cars", "audi");

        assertTrue(products.size() > 1);

        for (Product p : products) {
            assertNotNull(p.getTitle());
            assertNotNull(p.getDescription());
            assertNotNull(p.getThumbnailImage());
            assertNotNull(p.getSite());
            assertNotNull(p.getPrice());
            assertNotNull(p.getUrl());
            assertNotNull(p.getCategory());
        }
    }

    public static void main(String[] args) {

    }

}
