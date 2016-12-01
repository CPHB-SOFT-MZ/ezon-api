/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import org.school.ezon.api.APIKeys;

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
        String category = "619";
        given()
                .contentType("application/json")
                .pathParam("category", category)
                .when()
                .get("http://svcs.ebay.com/services/search/FindingService/"
                        + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                        + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&descriptionSearch=true&categoryId={category}")
                .then()
                .statusCode(200);
    }

    /**
     * Test of getProductsBySearch method, of class EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearch() {
        String searchString = "piano";
        given()
                .contentType("application/json")
                .pathParam("searchString", searchString)
                .when()
                .get("http://svcs.ebay.com/services/search/FindingService/"
                        + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                        + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&"
                        + "keywords={searchString}")
                .then()
                .statusCode(200);
    }

    /**
     * Test of getProductsBySearchAndCategory method, of class
     * EbayDataCollector.
     */
    @Test
    public void testGetProductsBySearchAndCategory() {
        String category = "619";
        String searchString = "piano";
        given()
                .contentType("application/json")
                .pathParam("category", category)
                .pathParam("searchString", searchString)
                .when()
                .get("http://svcs.ebay.com/services/search/FindingService/"
                        + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                        + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&"
                        + "keywords={searchString}&descriptionSearch=true&categoryId={category}")
                .then()
                .statusCode(200);
    }

}
