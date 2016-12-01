/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.school.ezon.api.pojo.Product;
import org.school.ezon.api.sorters.SortByPrice;

/**
 *
 * @author Mikkel
 */
public class Controller {
    
    private final ICollectorController collectorControl;
    
    public Controller(ICollectorController collectorControl){
        this.collectorControl = collectorControl;
    }
    
    public List<Product> getProductsFromCategory(String category){
        return collectorControl.getProductsFromCategory(category);
    }
    
    /**
     * Returns the CollectorControllers method by the same same
     * @param searchString
     * @return 
     */
    public List<Product> getProductsBySearch(String searchString) {
        List<Product> products = collectorControl.getProductsBySearch(searchString);
        Collections.sort(products, new SortByPrice());
        return products;
    }
    
    /**
     * Not yet implemented
     * @param category
     * @param searchString
     * @return 
     */
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        return collectorControl.getProductsBySearchAndCategory(category, searchString);
    }
}
