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
    
    public static Controller getController(){
        DataFormatter dbaFormatter = new DBAFormatter();
        List<DataCollector> dcs = new ArrayList();
        DataCollector dbaCollector = new DBADataCollector(dbaFormatter);
        dcs.add(dbaCollector);
        ICollectorController cc = new CollectorController(dcs);
        return new Controller(cc);
    }
}
