package com.NWACoders.mkOne.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Images {

    @Id
    @GeneratedValue
    private int id;
    //will be a uuid
    private String imageCode;

    //auto generated from?
    private String imageName;

    //max size?
    private Float size;

    public int getId(){
        return this.id;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }
}
