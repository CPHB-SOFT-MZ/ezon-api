/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mikkel
 */
public class CategoryConverter {

    private static HashMap<String, HashMap<String, String>> categories;

    public static void populateCategories() {
        categories = new HashMap();
        categories.put("cars", new HashMap());
        categories.get("cars").put("dba", "1");
        categories.get("cars").put("amazon", "248878031");

        categories.put("caraccess", new HashMap());
        categories.get("caraccess").put("dba", "46");

        categories.put("homes", new HashMap());
        categories.get("homes").put("dba", "3");

        categories.put("homeaccess", new HashMap());
        categories.get("homeaccess").put("dba", "26");

        categories.put("gardenbuild", new HashMap());
        categories.get("gardenbuild").put("dba", "21");

        categories.put("scooters", new HashMap());
        categories.get("scooters").put("dba", "30");

        categories.put("mc", new HashMap());
        categories.get("mc").put("dba", "8");

        categories.put("computersconsoles", new HashMap());
        categories.get("computersconsoles").put("dba", "2");

        categories.put("mobiles", new HashMap());
        categories.get("mobiles").put("dba", "31");

        categories.put("picturesound", new HashMap());
        categories.get("picturesound").put("dba", "10");

        categories.put("animals", new HashMap());
        categories.get("animals").put("dba", "19");

        categories.put("jobs", new HashMap());
        categories.get("jobs").put("dba", "39");

        categories.put("tickets", new HashMap());
        categories.get("tickets").put("dba", "40");

        categories.put("clothesfashion", new HashMap());
        categories.get("clothesfashion").put("dba", "37");

        categories.put("sport", new HashMap());
        categories.get("sport").put("dba", "4");

        categories.put("hobby", new HashMap());
        categories.get("hobby").put("dba", "36");
        categories.get("hobby").put("amazon", "11052591");

        categories.put("bikes", new HashMap());
        categories.get("bikes").put("dba", "20");

        categories.put("musicinstruments", new HashMap());
        categories.get("musicinstruments").put("dba", "23");

        categories.put("camping", new HashMap());
        categories.get("camping").put("dba", "25");

        categories.put("kids", new HashMap());
        categories.get("kids").put("dba", "5");

        categories.put("books", new HashMap());
        categories.get("books").put("dba", "16");

        categories.put("industry", new HashMap());
        categories.get("industry").put("dba", "7");

        categories.put("vacation", new HashMap());
        categories.get("vacation").put("dba", "13");

        categories.put("boats", new HashMap());
        categories.get("boats").put("dba", "11");

        categories.put("other", new HashMap());
        categories.get("other").put("dba", "14");
    }

    public static String convertCategoryToDestination(String category, String destination) {
        if (categories == null) {
            populateCategories();
        }

        return categories.get(category).get(destination);
    }

    public HashMap<String, String> convertCategory(String category) {
        if (categories == null) {
            populateCategories();
        }

        return categories.get(category);
    }

    public static String convertFromValue(String id, String site) {
        if (categories == null) {
            populateCategories();
        }

        String key = "";
        for (Map.Entry<String, HashMap<String, String>> entry : categories.entrySet()) {
            if (entry.getValue().containsValue(id) && entry.getValue().containsKey(site)) {
                key = entry.getKey();
                break;
            }
        }

        return key;
    }

}
