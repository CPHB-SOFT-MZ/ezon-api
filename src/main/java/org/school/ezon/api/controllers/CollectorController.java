/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.entity.AllSearches;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class CollectorController implements ICollectorController {

    private final ExecutorService threadPool = Executors.newCachedThreadPool();
    private final List<DataCollector> dataCollectors;

    public CollectorController(List<DataCollector> dataCollectors) {
        this.dataCollectors = dataCollectors;
    }

    @Override
    public List<Product> getProductsBySearchAndCategory(String category, String searchString) {
        List<Product> products = new ArrayList();
        List<Callable<List<Product>>> callables = new ArrayList();
        List<Future<List<Product>>> futures = new ArrayList();

        for (DataCollector dc : dataCollectors) {
            callables.add(new CollectorRunnerSearchByStringAndCategory(dc, searchString, category));
        }

        try {
            futures = threadPool.invokeAll(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (Future<List<Product>> future : futures) {
                products.addAll(future.get());
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // threadPool.shutdown();
        return products;
    }

    @Override
    public List<Product> getProductsBySearch(String searchString) {
        List<Product> products = new ArrayList();
        List<Callable<List<Product>>> callables = new ArrayList();
        List<Future<List<Product>>> futures = new ArrayList();

        for (DataCollector dc : dataCollectors) {
            callables.add(new CollectorRunnerSearchByString(dc, searchString));
        }

        try {
            futures = threadPool.invokeAll(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (Future<List<Product>> future : futures) {
                products.addAll(future.get());
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //threadPool.shutdown();
        return products;
    }

    @Override
    public List<Product> getProductsFromCategory(String category) {
        List<Product> products = new ArrayList();
        List<Callable<List<Product>>> callables = new ArrayList();
        List<Future<List<Product>>> futures = new ArrayList();

        for (DataCollector dc : dataCollectors) {
            callables.add(new CollectorRunnerSearchByCategory(dc, category));
        }

        try {
            futures = threadPool.invokeAll(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (Future<List<Product>> future : futures) {
                products.addAll(future.get());
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //threadPool.shutdown();
        return products;
    }

    @Override
    public List<Product> getPopularProducts(List<AllSearches> searches) {
        List<Product> products = new ArrayList();
        List<Callable<List<Product>>> callables = new ArrayList();
        List<Future<List<Product>>> futures = new ArrayList();

        for (DataCollector dc : dataCollectors) {
            for (AllSearches search : searches) {
                callables.add(new CollectorRunnerSearchByString(dc, search.getSearchWord()));
            }
        }

        try {
            futures = threadPool.invokeAll(callables);
        } catch (InterruptedException ex) {
            Logger.getLogger(CollectorController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            for (Future<List<Product>> future : futures) {
                products.addAll(future.get());
            }
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        //threadPool.shutdown();
        return limitProducts(products);
    }

    public List<Product> limitProducts(List<Product> products) {
        List<Product> finalProducts = new ArrayList();
        Collections.shuffle(products);

        int dba = 0;
        int ebay = 0;
        for (Product p : products) {
            if (dba > 1 && ebay > 1) {
                break;
            } else if (p.getSite().equals("dba") && dba < 2) {
                finalProducts.add(p);
                dba++;
            } else if (p.getSite().equals("ebay") && ebay < 2) {
                finalProducts.add(p);
                ebay++;
            }
        }

        return finalProducts;
    }

}
