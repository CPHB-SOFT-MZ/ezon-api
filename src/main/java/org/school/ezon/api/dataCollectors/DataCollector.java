/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

import java.util.List;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public interface DataCollector {

    List<Product> getProductsFromCategory(String categoryId);

    List<Product> getProductsBySearch(String searchString);

    List<Product> getProductsBySearchAndCategory(String categoryId, String searchString);
    String getDataCollectorID();
}
