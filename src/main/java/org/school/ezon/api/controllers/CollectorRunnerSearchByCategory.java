/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.concurrent.Callable;
import org.school.ezon.api.dataCollectors.DataCollector;

/**
 *
 * @author Mikkel
 */
public class CollectorRunnerSearchByCategory implements Callable{
    private final DataCollector dataCollector;
    private final String category;
    
    public CollectorRunnerSearchByCategory(DataCollector dc, String category){
        this.dataCollector = dc;
        this.category = category;
    }

    @Override
    public Object call() throws Exception {
        return dataCollector.getProductsFromCategory(category);
    }
}
