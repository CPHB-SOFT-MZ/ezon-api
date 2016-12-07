/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.endpoints;

import static io.restassured.RestAssured.given;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kaspe
 */
public class ProductsEndpointIT {

    public ProductsEndpointIT() {
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
     * Test of getProductsBySearch method, of class ProductsEndpoint.
     */
    @Test
    public void testGetProductsBySearch() {
        System.out.println("getProductsBySearch");
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:8084/api/api/products/audi")
                .then()
                .statusCode(200);
    }

    /**
     * Test of getProductsByCategory method, of class ProductsEndpoint.
     */
    @Test
    public void testGetProductsByCategory() {
        System.out.println("getProductsByCategory");
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:8084/api/api/products/category/1")
                .then()
                .statusCode(200);
    }

    /**
     * Test of getProductsBySearchAndCategory method, of class ProductsEndpoint.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        System.out.println("getProductsBySearchAndCategory");
        given()
                .contentType("application/json")
                .when()
                .get("http://localhost:8084/api/api/products/1/audi")
                .then()
                .statusCode(200);
    }

}
