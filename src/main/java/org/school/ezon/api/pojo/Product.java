/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.school.ezon.api.pojo;

/**
 *
 * @author Mikkel
 */
public class Product {

    private String title;
    //private String category;
    private String description;
    private String price;
    private String url;
    private String site;
    private String thumbnailImage;

    public Product(String title, String description, String price, String url, String site, String thumbnailImage) {
        this.title = title;
        this.description = description;
        //this.category = category;
        this.price = price;
        this.url = url;
        this.site = site;
        this.thumbnailImage = thumbnailImage;
    }

    public Product() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

}
