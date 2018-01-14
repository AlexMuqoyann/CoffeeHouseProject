package com.example.hp.coffeeh.models;


public class HotTea {
    private String name, image, price, rowPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(String rowPrice) {
        this.rowPrice = rowPrice;
    }

    public HotTea() {

    }

    public HotTea(String name, String image, String price, String rowPrice) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.rowPrice = rowPrice;
    }
}
