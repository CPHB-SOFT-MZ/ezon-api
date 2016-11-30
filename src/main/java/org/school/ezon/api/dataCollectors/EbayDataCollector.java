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

        WebTarget target = client.target("https://api.ebay.com/buy/browse/v1/item_group/" + catId);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));

    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target();
        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        Client client = ClientBuilder.newClient();
        String catId = CategoryConverter.convertCategoryToDestination(category, "ebay");
        WebTarget target = client.target();

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

}
