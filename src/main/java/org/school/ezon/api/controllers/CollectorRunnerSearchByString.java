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
public class CollectorRunnerSearchByString implements Callable{
    private final DataCollector dataCollector;
    private final String searchString;
    
    public CollectorRunnerSearchByString(DataCollector dc, String searchString){
        this.dataCollector = dc;
        this.searchString = searchString;
    }

    @Override
    public Object call() throws Exception {
        return dataCollector.getProductsBySearch(searchString);
    }
    
    
}
