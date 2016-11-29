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
 * @author danie
 */
public class EBAYFormatter implements DataFormatter {

    @Override
    public List<Product> formatProducts(String jsonFormat) {
        List<Product> ads = new ArrayList();

        JsonArray jsonArr = new JsonParser().parse(jsonFormat).getAsJsonObject()
                .getAsJsonArray("findItemsByKeywordsResponse").get(0)
                .getAsJsonObject().getAsJsonArray("searchResult").get(0)
                .getAsJsonObject().getAsJsonArray("item");

        if (jsonArr == null) {
            return ads;
        }

        for (JsonElement e : jsonArr) {

            JsonObject jsonAd = e.getAsJsonObject();

            String title = jsonAd.get("title").getAsString();

            String adLink = jsonAd.get("viewItemURL").getAsString();

            String thumbnail = "";
            if (jsonAd.get("galleryURL") != null) {
                thumbnail = jsonAd.get("galleryURL").getAsString();
            }

            float price = jsonAd.getAsJsonArray("sellingStatus").get(0)
                    .getAsJsonObject().getAsJsonArray("currentPrice").get(0)
                    .getAsJsonObject().get("__value__").getAsFloat();

            Product product = new Product(title, "", "", price, adLink, "ebay", thumbnail);
            ads.add(product);
        }

        return ads;
    }
}
