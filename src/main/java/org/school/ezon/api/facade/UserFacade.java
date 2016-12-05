/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.facade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.school.ezon.api.Exceptions.UserExistException;
import org.school.ezon.api.dataFormatters.KeywordFormatter;
import org.school.ezon.api.entity.AllSearches;
import org.school.ezon.api.entity.UserSearches;
import org.school.ezon.api.entity.Users;

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
    public Users createUser(String email, String password) throws UserExistException {
        EntityManager em = getEntityManager();
        try {
            Users user = new Users(email, password);
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

    @Override
    public UserSearches updateUserSearch(Users user, String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AllSearches updateUnspecificSearch(String keyword) {
        EntityManager em = getEntityManager();
        keyword = KeywordFormatter.format(keyword);
        AllSearches as = new AllSearches();
        as.setSearchWord(keyword);
        as.setCount(1);

        AllSearches existingObject = em.find(AllSearches.class, keyword);

        if (existingObject == null) {
            em.getTransaction().begin();
            em.persist(as);
            em.getTransaction().commit();
            em.close();
            return as;
        } else {
            em.getTransaction().begin();
            existingObject.setCount(existingObject.getCount() + 1);
            em.merge(existingObject);
            em.getTransaction().commit();
            em.close();
            return existingObject;
        }
    }

    private AllSearches findSearch(String keyword) {
        EntityManager em = getEntityManager();
        return null;
    }

    @Override
    public List<AllSearches> getPopularSearches() {
        List<AllSearches> popularSearches = new ArrayList();
        EntityManager em = getEntityManager();

        popularSearches = (List) em.createQuery("SELECT alls from AllSearches alls ORDER BY alls.count DESC", AllSearches.class).setMaxResults(4).getResultList();

        return popularSearches;
    }

}
