package com.NWACoders.mkOne.models;

import jdk.jfr.DataAmount;

import javax.persistence.*;

@Entity
public class Images {

    @Id
    @GeneratedValue
    private int id;
    //will be a uuid

//    private String imageCode;

    //auto generated from?
    private String name;

    //max size 5MB
//    @DataAmount("5MB")
    private Float size;

    public int getId(){
        return this.id;
    }

//    public String getImageCode() {
//        return imageCode;
//    }
//
//    public void setImageCode(String imageCode) {
//        this.imageCode = imageCode;
//    }

    public String getName() {
        return name;
    }

    public void setImageName(String imageName) {
        this.name = name;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }
}
