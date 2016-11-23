/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import static io.restassured.RestAssured.given;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.school.ezon.api.pojo.Product;
import static io.restassured.RestAssured.given;

/**
 *
 * @author philliphbrink
 */
public class IntergrationDBADataCollectorTest {

    public IntergrationDBADataCollectorTest() {
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
     * This method test that we have a connection to the api.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        String category = "1";
        String searchString = "audi";
        given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .pathParam("category", category)
                .pathParam("searchString", searchString)
                .when()
                .get("https://api.dba.dk/api/v2/ads/cassearch?q={searchString}&cla={category}")
                .then()
                .statusCode(200);
    }

}
