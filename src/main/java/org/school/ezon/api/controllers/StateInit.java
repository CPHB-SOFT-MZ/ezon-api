/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.controllers;

import java.util.ArrayList;
import java.util.List;
import org.school.ezon.api.dataCollectors.DBADataCollector;
import org.school.ezon.api.dataCollectors.DataCollector;
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;

/**
 *
 * @author Mikkel
 */
public class StateInit {
    private static DataFormatter dbaFormatter;
    private static DataCollector dbaCollector;
    private static DataFormatter ebayFormatter;
    private static DataCollector ebayCollector;
    private static ICollectorController cc;
    private static Controller controller;
    public static Controller getController(){
        if(controller == null){
            dbaFormatter = new DBAFormatter();
            List<DataCollector> dcs = new ArrayList();
            dbaCollector = new DBADataCollector(dbaFormatter);

            //TODO: Instantiate the correct implementation of the formatter and collector for ebay here
            ebayFormatter = null;
            ebayCollector= null;
            dcs.add(dbaCollector);
            //dcs.add(ebayCollector);
            cc = new CollectorController(dcs);
            controller = new Controller(cc);
        }
        return controller;
    }
}
