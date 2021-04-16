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

    private String name;
    private String description;
    private float price;

    //Add validation for productImage
    private String image;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public void setProductName(String productName) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setProductImage(String productImage) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productImage='" + image + '\'' +
                '}';
    }
}
