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
public interface ICollectorController {
    List<Product> getProductsBySearchAndCategory(String category, String searchString);
    List<Product> getProductsBySearch(String searchString);
    List<Product> getProductsFromCategory(String category);
            
}
