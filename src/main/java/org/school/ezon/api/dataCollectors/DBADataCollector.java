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
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class DBADataCollector implements DataCollector {

    private final DataFormatter dataFormatter;

    public DBADataCollector(DataFormatter dataFormatter) {
        this.dataFormatter = dataFormatter;
    }

    /**
     * Returns a list of products given a specific category from DBA
     *
     * @param categoryId
     * @return
     */
    @Override
    public List<Product> getProductsFromCategory(String categoryId) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?sec=" + categoryId);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                    .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

    /**
     * Returns a list of products given a specific search string from DBA
     *
     * @param searchString
     * @return
     */
    @Override
    public List<Product> getProductsBySearch(String searchString) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?ps=20&q=" + searchString + "&sort=price-asc");
        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

    /**
     * This method takes a category - number, searchString - String and makes a
     * connection to DBA Api and retruns a list of products.
     *
     * @param categoryId
     * @param searchString
     * @return The method returns a list of products. If category is not a
     * number i will throw Exception.
     */
    @Override
    public List<Product> getProductsBySearchAndCategory(String categoryId, String searchString) {

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?q=" + searchString + "&sec=" + categoryId);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }
}
