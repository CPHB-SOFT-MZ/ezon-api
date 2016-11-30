/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.school.ezon.api.dataCollectors.DBADataCollector;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class Tester {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DataFormatter dbaFormatter = new DBAFormatter();
        List<DataCollector> dcs = new ArrayList();
        DataCollector dbaCollector = new DBADataCollector(dbaFormatter);
        dcs.add(dbaCollector);
        ICollectorController cc = new CollectorController(dcs);
        List<Product> products = cc.getProductsBySearch("audi");
        
        for(Product product : products){
            System.out.println(product.getUrl());
        }
    }
}
