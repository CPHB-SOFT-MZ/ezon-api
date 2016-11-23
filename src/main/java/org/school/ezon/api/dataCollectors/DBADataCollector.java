/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.io.IOException;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class DBADataCollector implements DataCollector{

    private DataFormatter dataFormatter;
    
    public DBADataCollector(DataFormatter dataFormatter){
        this.dataFormatter = dataFormatter;
    }
    
    @Override
    public List<Product> getProductsFromCategory(String category) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?q=&cla=" + category);

        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.dba.dk/api/v2/ads/cassearch?q=" + searchString);
        return dataFormatter.formatProducts(target.request(MediaType.APPLICATION_JSON)
                .header("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857")
                .get(String.class));
    }

    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
