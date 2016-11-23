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
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class DBADataCollector implements DataCollector {

    @Override
    public List<Product> getProductsFromCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method takes a category - number, searchString - String and makes a connection to DBA Api and retruns a list of products.
     * @param category
     * @param searchString
     * @return The method returns a list of products. If category is not a number i will throw Exception.
     */
    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {

        DataFormatter dataFormatter = new DBAFormatter();

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?q=" + searchString + "&cla=" + category);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }
}
