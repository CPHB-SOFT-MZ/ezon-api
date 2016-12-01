/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.facade;

import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.school.ezon.api.entity.Users;

/**
 *
 * @author kaspe
 */
public class UserFacadeTest {
    
    UserFacade facade = new UserFacade(Persistence.createEntityManagerFactory("pu_test"));
    
    public UserFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserFacade.
     */
    @Test
    public void testCreateUser() throws Exception {
        System.out.println("createUser");
        String email = "Kasper";
        String password = "1234";
        Users result = facade.createUser(email, password);
        assertEquals(email, result.getEmail());
    }
    
}
