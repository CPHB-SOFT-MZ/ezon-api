/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author philliphbrink
 */
@Entity
public class UserSearches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String searchWord;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (searchWord != null ? searchWord.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the searchWord fields are not set
        if (!(object instanceof UserSearches)) {
            return false;
        }
        UserSearches other = (UserSearches) object;
        if ((this.searchWord == null && other.searchWord != null) || (this.searchWord != null && !this.searchWord.equals(other.searchWord))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.school.ezon.api.entity.UserSearches[ id=" + searchWord + " ]";
    }
    
}
