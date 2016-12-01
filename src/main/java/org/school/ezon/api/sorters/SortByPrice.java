/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.sorters;

import java.util.Comparator;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class SortByPrice implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Product pr1 = (Product) o1;
        Product pr2 = (Product) o2;
        if (Integer.valueOf(pr1.getPrice()) < Integer.valueOf(pr2.getPrice())) {
            return -1;
        }
        if (Integer.valueOf(pr1.getPrice()) > Integer.valueOf(pr2.getPrice())) {
            return 1;
        }
        return 0;
    }

}
