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
import org.school.ezon.api.dataCollectors.EbayDataCollector;
import org.school.ezon.api.dataFormatters.DBAFormatter;
import org.school.ezon.api.dataFormatters.DataFormatter;
import org.school.ezon.api.dataFormatters.EbayFormatter;
import org.school.ezon.api.facade.Facade;
import org.school.ezon.api.facade.UserFacade;
import org.school.ezon.api.facade.UserFacadeFactory;

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
    private static Facade facade;
    public static Controller getController(){
        if(controller == null){
            dbaFormatter = new DBAFormatter();
            List<DataCollector> dcs = new ArrayList();
            dbaCollector = new DBADataCollector(dbaFormatter);

            //TODO: Instantiate the correct implementation of the formatter and collector for ebay here
            ebayFormatter = new EbayFormatter();
            ebayCollector= new EbayDataCollector(ebayFormatter);
            dcs.add(dbaCollector);
            dcs.add(ebayCollector);
            cc = new CollectorController(dcs);
            facade = UserFacadeFactory.getInstance();
            controller = new Controller(cc, facade);
        }
        return controller;
    }
}
