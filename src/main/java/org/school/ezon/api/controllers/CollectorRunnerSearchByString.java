/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.List;
import java.util.concurrent.Callable;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class CollectorRunnerSearchByString implements Callable{
    private final DataCollector dataCollector;
    private List<Product> products;
    private final String searchString;
    private final CollectorController cc;
    
    public CollectorRunnerSearchByString(CollectorController cc, DataCollector dc, String searchString){
        this.dataCollector = dc;
        this.searchString = searchString;
        this.cc = cc;
    }

    /*@Override
    public void run() {
        products = 
        cc.notifyMe(products);
    }*/

    @Override
    public Object call() throws Exception {
        return dataCollector.getProductsBySearch(searchString);
    }
    
    
}
