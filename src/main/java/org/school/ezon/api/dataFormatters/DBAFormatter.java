/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class DBAFormatter implements DataFormatter {

//    private static DBAFormatter instance = null;
//
//    public static DBAFormatter getClassInstance() {
//        if (instance == null) {
//            instance = new DBAFormatter();
//        }
//        return instance;
//    }
    
    /**
     * 
     * @param jsonFormat
     * @return If the input is valid, the method will return a List of Products, else it will throw an exception. 
     */
    @Override
    public List<Product> formatProducts(String jsonFormat) {

        List<Product> products = new ArrayList();

        JsonArray jsonArr = new JsonParser()
                .parse(jsonFormat).getAsJsonObject()
                .get("ads").getAsJsonArray();

        for (JsonElement e : jsonArr) {

            JsonObject jsonAd = e.getAsJsonObject();

            String title = jsonAd.get("title").getAsString();

            String adLink = jsonAd.getAsJsonObject("ad-url").get("href").getAsString();

            String description = jsonAd.get("description").getAsString();

            String thumbnail = "";
            if (jsonAd.getAsJsonArray("pictures").size() > 0) {

                thumbnail = jsonAd.getAsJsonArray("pictures").get(0)
                        .getAsJsonObject().getAsJsonArray("link").get(0)
                        .getAsJsonObject().get("href").getAsString();
            }

            int price = jsonAd.get("price").getAsInt();

            Product product = new Product(title, description, price, adLink, "dba", thumbnail);
            products.add(product);
        }

        return products;
    }

}
