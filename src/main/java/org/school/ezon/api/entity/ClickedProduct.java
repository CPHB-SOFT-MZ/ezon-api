/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Mikkel
 */
@Entity
public class ClickedProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String url;
    private int count;
    private String title;
    private float price;
    private String location;

    public ClickedProduct(){
        
    }

    public ClickedProduct(String url, int count, String title, float price, String location) {
        this.url = url;
        this.count = count;
        this.title = title;
        this.price = price;
        this.location = location;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (url != null ? url.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the url fields are not set
        if (!(object instanceof ClickedProduct)) {
            return false;
        }
        ClickedProduct other = (ClickedProduct) object;
        if ((this.url == null && other.url != null) || (this.url != null && !this.url.equals(other.url))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.school.ezon.api.entity.ClickedProduct[ id=" + url + " ]";
    }
    
}
