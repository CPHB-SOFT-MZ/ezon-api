/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.dataCollectors;

/**
 *
 * @author philliphbrink
 */
public class test {

    public static void main(String[] args) {
        
        DataCollector dba = new DBADataCollector();
        System.out.println(dba.getProductsBySearchAndCategory("audi", "1"));
    }
}
