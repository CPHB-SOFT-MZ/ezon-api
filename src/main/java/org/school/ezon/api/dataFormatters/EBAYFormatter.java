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
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author danie
 */
public class EBAYFormatter implements DataFormatter {

    @Override
    public List<Product> formatProducts(String jsonFormat) {
        List<Product> ads = new ArrayList();
        float rate = 2;
                //CurrencyConverter.getExchangeRate();

        JsonArray jsonArr = new JsonParser().parse(jsonFormat).getAsJsonObject()
                .getAsJsonArray("itemSummaries");

        if (jsonArr == null) {
            return ads;
        }

        for (JsonElement e : jsonArr) {

            JsonObject jsonAd = e.getAsJsonObject();

            String title = jsonAd.get("title").getAsString();

            String adLink = jsonAd.get("viewItemURL").getAsString();

//            String category = "";
//            for (JsonElement cat : jsonAd.getAsJsonArray("categories")) {
//                String curCat = cat.getAsJsonObject().get("categoryId").getAsString();
//
//                if (CategoryConverter.isValidEbayCatId(curCat)) {
//                    category = CategoryConverter.convertFromValue(curCat, "ebay");
//                    break;
//                }
//            }
            String thumbnail = "";
            if (jsonAd.get("galleryURL") != null) {
                thumbnail = jsonAd.get("galleryURL").getAsString();
            }

            String description = "See product link for the description";

            float priceUSD = jsonAd.getAsJsonArray("sellingStatus").get(0)
                    .getAsJsonObject().getAsJsonArray("currentPrice").get(0)
                    .getAsJsonObject().get("__value__").getAsFloat();
            priceUSD *= rate;
            String price = String.format("%.2f", priceUSD);

            Product product = new Product(title, description, price, adLink, "ebay", thumbnail);
            ads.add(product);
        }

        return ads;
    }

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://svcs.ebay.com/services/search/FindingService/v1?OPERATION-NAME=findItemsAdvanced&SERVICE-VERSION=1.12.0&SECURITY-APPNAME=DanielWi-3Semeste-PRD-c45f64428-bc9a0454&RESPONSE-DATA-FORMAT=JSON&REST-PAYLOAD&paginationInput.entriesPerPage=10&keywords=tolkien&descriptionSearch=true&categoryId=1");

        List<Product> products = new EBAYFormatter().formatProducts(target.request(MediaType.APPLICATION_JSON)
                .get(String.class));

        for (Product p : products) {
            System.out.println(p.getPrice());
            System.out.println(p.getTitle());
        }

    }
}
