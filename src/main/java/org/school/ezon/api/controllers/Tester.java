/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;
import org.school.ezon.api.pojo.Product;

/**
 *
 * @author Mikkel
 */
public class Tester {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Controller ctrl = StateInit.getController();
        List<Product> products = ctrl.getProductsBySearch("audi");
        for(Product product : products){
            System.out.println(product.getUrl());
        }
    }
}
