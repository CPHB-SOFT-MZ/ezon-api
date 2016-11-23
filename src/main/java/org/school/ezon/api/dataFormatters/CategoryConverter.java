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
    private HashMap<String, HashMap<String, String>> categories;
    
    public CategoryConverter(){
        this.categories = new HashMap();
        this.categories.put("cars", new HashMap());
        this.categories.get("cars").put("dba", "Biler");
        this.categories.get("cars").put("amazon", "CarsAndVehicles");
        this.categories.get("cars").put("ebay", "Cars");
    }
    
    
    public String convert(String category, String destination){
        return this.categories.get(category).get(destination);
    }
    
    
    
}
