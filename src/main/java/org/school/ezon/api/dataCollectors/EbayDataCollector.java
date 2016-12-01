/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.school.ezon.api.APIKeys;
import org.school.ezon.api.dataFormatters.CategoryConverter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author kaspe
 */
public class EbayDataCollector implements DataCollector {

    private final DataFormatter dataFormatter;

    public EbayDataCollector(DataFormatter dataFormatter) {
        this.dataFormatter = dataFormatter;
    }

    @Override
    public List<Product> getProductsFromCategory(String category) {

        Client client = ClientBuilder.newClient();
        String catId = CategoryConverter.convertCategoryToDestination(category, "ebay");

        WebTarget target = client.target("http://svcs.ebay.com/services/search/FindingService/"
                + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&descriptionSearch=true&categoryId=" + category);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .header("Authorization", APIKeys.EbayKey())
                .get(String.class));

    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://svcs.ebay.com/services/search/FindingService/"
                + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&"
                + "keywords=" + searchString);
        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .header("Authorization", APIKeys.EbayKey())
                .get(String.class));
    }

    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        Client client = ClientBuilder.newClient();
        String catId = CategoryConverter.convertCategoryToDestination(category, "ebay");
        WebTarget target = client.target("http://svcs.ebay.com/services/search/FindingService/"
                + "v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME="
                + APIKeys.EbayKey() + "&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=20&"
                + "keywords=" + searchString + "&descriptionSearch=true&categoryId=" + category);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("Content-Type", "application/json")
                .header("Authorization", APIKeys.EbayKey())
                .get(String.class));
    }

}
