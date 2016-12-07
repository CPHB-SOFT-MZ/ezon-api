/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mikkel
 */
public class CategoryConverter {

    private static HashMap<String, HashMap<String, String[]>> categories;
    private static List<String> eBayCatIds = Arrays.asList("10542", "11700", "870", "625", "15032", "58058", "293", "11232", "1249", "1281", "1305", "11450", "281", "888", "64482", "11116", "1", "14339", "260", "220", "11233", "619", "2984", "237", "267", "12576", "3252", "200081", "550", "45100", "172008", "26395", "99", "316");

    public static void populateCategories() {
        categories = new HashMap();
        categories.put("vehiclesandaccess", new HashMap());
        categories.get("vehiclesandaccess").put("dba", new String[]{"1", "30", "8", "20", "11", "46"});
        categories.get("vehiclesandaccess").put("ebay", new String[]{""});
        //categories.get("cars").put("amazon", new String[] {"248878031"});

        categories.put("estate", new HashMap());
        categories.get("estate").put("dba", new String[]{"3"});
        categories.get("estate").put("ebay", new String[]{"10542"});

        categories.put("homeaccess", new HashMap());
        categories.get("homeaccess").put("dba", new String[]{"26"});
        categories.get("homeaccess").put("ebay", new String[]{"11700", "870"});

        categories.put("electronics", new HashMap());
        categories.get("electronics").put("dba", new String[]{"2", "31", "10"});
        categories.get("electronics").put("ebay", new String[]{"625", "15032", "58058", "293", "11232", "1249"});

        categories.put("animals", new HashMap());
        categories.get("animals").put("dba", new String[]{"19"});
        categories.get("animals").put("ebay", new String[]{"1281"});

        categories.put("tickets", new HashMap());
        categories.get("tickets").put("dba", new String[]{"40"});
        categories.get("tickets").put("ebay", new String[]{"1305"});

        categories.put("clothesfashion", new HashMap());
        categories.get("clothesfashion").put("dba", new String[]{"37"});
        categories.get("clothesfashion").put("ebay", new String[]{"11450", "281"});

        categories.put("sport", new HashMap());
        categories.get("sport").put("dba", new String[]{"4"});
        categories.get("sport").put("ebay", new String[]{"888", "64482"});

        categories.put("hobby", new HashMap());
        categories.get("hobby").put("dba", new String[]{"36", "25"});
        categories.get("hobby").put("ebay", new String[]{"11116", "1", "14339", "260", "220"});
        //categories.get("hobby").put("amazon", new String[]{"11052591"});

        categories.put("music", new HashMap());
        categories.get("music").put("dba", new String[]{"23"});
        categories.get("music").put("ebay", new String[]{"11233", "619"});

        categories.put("kids", new HashMap());
        categories.get("kids").put("dba", new String[]{"5"});
        categories.get("kids").put("ebay", new String[]{"2984", "237"});

        categories.put("books", new HashMap());
        categories.get("books").put("dba", new String[]{"16"});
        categories.get("books").put("ebay", new String[]{"267"});

        categories.put("industry", new HashMap());
        categories.get("industry").put("dba", new String[]{"7"});
        categories.get("industry").put("ebay", new String[]{"12576"});

        categories.put("vacation", new HashMap());
        categories.get("vacation").put("dba", new String[]{"13"});
        categories.get("vacation").put("ebay", new String[]{"3252"});

        categories.put("other", new HashMap());
        categories.get("other").put("dba", new String[]{"14", "21", "39"});
        categories.get("other").put("ebay", new String[]{"200081", "550", "45100", "172008", "26395", "99", "316"});
    }

    public static boolean isValidEbayCatId(String catId) {
        return eBayCatIds.contains(catId);
    }

    public static String[] convertCategoryToDestination(String category, String destination) {
        if (categories == null) {
            populateCategories();
        }

        return categories.get(category).get(destination);
    }

//    public HashMap<String, String[]> convertCategory(String category) {
//        if (categories == null) {
//            populateCategories();
//        }
//
//        return categories.get(category);
//    }
//    public static String convertFromValue(String id, String site) {
//        if (categories == null) {
//            populateCategories();
//        }
//
//        String key = "";
//        for (Map.Entry<String, HashMap<String, String[]>> entry : categories.entrySet()) {
//
//            for (Map.Entry<String, String[]> entry1 : entry.getValue().entrySet()) {
//
//                if (entry1.getKey().equals(site)) {
//
//                    String[] ids = entry1.getValue();
//
//                    for (String curId : ids) {
//
//                        if (curId.equals(id)) {
//                            key = entry.getKey();
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//
//        return key;
//    }
}
