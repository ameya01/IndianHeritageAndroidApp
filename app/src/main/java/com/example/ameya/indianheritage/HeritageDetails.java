package com.example.ameya.indianheritage;

import java.io.Serializable;


public class HeritageDetails implements Serializable {

    private String name;
    private String address;
    private String image;
    private String url;
    private String information;

    public HeritageDetails(String name, String address, String image, String url, String information) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.url = url;
        this.information = information;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getInformation() {
        return information;
    }

    public void setInformation(String name) {
        this.information = information;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
