/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataFormatters;

import java.util.List;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public interface DataFormatter {
//    Product formatProduct(String jsonData);
    List<Product> formatProducts(String jsonFormat);
}
