/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.school.ezon.api.dataCollectors.DBADataCollector;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class CollectorController {
    private List<Product> products = new ArrayList();
    private ExecutorService threadPool = Executors.newCachedThreadPool();
    
    public void notifyMe(List<Product> products) {
        for(Product pr : products){
            this.products.add(pr);
        }
    }
    
    
    public List<Product> getProductsBySearchString(String search) throws InterruptedException, ExecutionException{
        DataFormatter dbaFormatter = new DBAFormatter();
        DataCollector dba = new DBADataCollector(dbaFormatter);

        Future<List<Product>> fut = this.threadPool.submit(new CollectorRunnerSearchByString(this, dba, search));
        Future<List<Product>> fut2 = this.threadPool.submit(new CollectorRunnerSearchByString(this, dba, "Macbook"));
        Future<List<Product>> fut3 = this.threadPool.submit(new CollectorRunnerSearchByString(this, dba, "project"));
            try{
                products.addAll(fut2.get());
                products.addAll(fut.get());
                products.addAll(fut3.get());
            } catch(ExecutionException ex){
                System.out.println(ex.getStackTrace());
            }
        

        //threadPool.shutdown();
        if(fut2.isDone() && fut.isDone() && fut3.isDone()){
            this.threadPool.shutdown();
        }
        return products;
    }
    
}
