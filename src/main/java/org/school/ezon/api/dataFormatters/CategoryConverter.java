/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import java.util.HashMap;

/**
 *
 * @author Mikkel
 */
public class CategoryConverter {
    private static HashMap<String, HashMap<String, String>> categories;
    
    public void populateCategories(){
        categories = new HashMap();
        categories.put("cars", new HashMap());
        categories.get("cars").put("dba", "1");
        categories.get("cars").put("amazon", "248878031");
        
        categories.put("home", new HashMap());
        categories.get("home").put("dba", "2");
        
        categories.put("mc", new HashMap());
        categories.get("mc").put("dba", "3");
        
        categories.put("computersphones", new HashMap());
        categories.get("computersphones").put("dba", "4");
        
        categories.put("picturesound", new HashMap());
        categories.get("picturesound").put("dba", "5");
        
        categories.put("animals", new HashMap());
        categories.get("animals").put("dba", "6");
        
        categories.put("hobby", new HashMap());
        categories.get("hobby").put("dba", "7");
        categories.get("hobby").put("amazon", "11052591");
        
        
        categories.put("family", new HashMap());
        categories.get("family").put("dba", "8");
        
        categories.put("books", new HashMap());
        categories.get("books").put("dba", "9");
        
        categories.put("industry", new HashMap());
        categories.get("industry").put("dba", "10");
        
        categories.put("vacation", new HashMap());
        categories.get("vacation").put("dba", "11");
        
        categories.put("other", new HashMap());
        categories.get("other").put("dba", "12");
    }
    
    
    public String convertCategoryToDestination(String category, String destination){
        if(categories == null){
            populateCategories();
        }
        return categories.get(category).get(destination);
    }
    
    public HashMap<String, String> convertCategory(String category){
        if(categories == null){
            populateCategories();
        }
        return categories.get(category);
    }
    
    
    
}
