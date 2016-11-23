/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;
import org.json.simple.parser.JSONParser;


/**
 *
 * @author Mikkel
 */
public class DBADataCollector implements DataCollector{

    @Override
    public List<Product> getProductsFromCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        DataFormatter dataFormatter = new DBAFormatter();
        String url = "https://api.dba.dk/api/v2/ads/cassearch?q="+searchString+"&cla="+category;
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()){
            HttpGet request = new HttpGet(url);
            request.setHeader("Content-Type", "application/json");
            request.addHeader("dbaapikey", "087157d7-84d5-4f2b-1d02-08d282f6c857");
            for (Header object : request.getAllHeaders()) {
                System.out.println(object.getName()+ "  " + object.getValue());
            }
            HttpResponse result = httpClient.execute(request);
            String json = EntityUtils.toString(result.getEntity(), "UTF-8");
            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(json);
            return dataFormatter.formatProducts(json);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
       
    }
    
}
