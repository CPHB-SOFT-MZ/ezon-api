/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.facade;

import org.school.ezon.api.Exceptions.UserExistException;
import org.school.ezon.api.entity.Users;

/**
 *
 * @author philliphbrink
 */
public interface Facade {
    
    public Users createUser(String email, String pasword) throws UserExistException;
}
