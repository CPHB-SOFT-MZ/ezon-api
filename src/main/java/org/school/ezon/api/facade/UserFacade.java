/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.facade;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.school.ezon.api.Exceptions.UserExistException;
import org.school.ezon.api.entity.User;

/**
 *
 * @author philliphbrink
 */
public class UserFacade implements Facade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public User createUser(String email, String password) throws UserExistException {
        EntityManager em = getEntityManager();
        try {
            User user = new User(email, password);
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return user;
        } catch (EntityExistsException e) {
            throw new UserExistException("The user already exists, please use another email");
        } finally {
            em.close();
        }
    }

}
