package com.NWACoders.mkOne.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Products {
    //modeling the database
    //creating the variables to be searched inside the database api
    @Id
    @GeneratedValue
    private int id;

    private String productName;
    private String description;
    private float price;

    //Add validation for productImage
    private String productImage;


    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productImage='" + productImage + '\'' +
                '}';
    }
}
