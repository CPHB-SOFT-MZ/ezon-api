/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.facade;

import javax.persistence.Persistence;

/**
 *
 * @author kaspe
 */
public class UserFacadeFactory {
private static final Facade instance = 
            new UserFacade(Persistence.createEntityManagerFactory("ezon"));
    public static Facade getInstance(){
        return instance;
    }
}
