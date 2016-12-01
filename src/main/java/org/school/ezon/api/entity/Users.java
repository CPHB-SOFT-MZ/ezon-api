/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author philliphbrink
 */
@Entity
public class Users implements Serializable {

    @Id
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<UserSearches> userSearches = new ArrayList();
    
    public Users(){
    }

    public Users(String email, String password) {
        this.email = email;
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserSearches> getSearches() {
        return userSearches;
    }

    public void setSearches(List<UserSearches> searches) {
        this.userSearches = searches;
    }

    public void addSearches(UserSearches search) {
        userSearches.add(search);
    }

}
