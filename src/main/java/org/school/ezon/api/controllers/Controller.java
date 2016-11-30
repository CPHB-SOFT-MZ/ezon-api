/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.List;
import org.school.ezon.api.pojo.Product;

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
        return collectorControl.getProductsBySearch(searchString);
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
