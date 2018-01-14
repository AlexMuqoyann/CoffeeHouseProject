package com.example.hp.coffeeh.models;

/**
 * Created by HP on 05.12.2017.
 */

public class SmoothieDetail {
    private String name;
    private String price;
    private String count;
    private String sugar;
    private String orderIn;
    private String id;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public SmoothieDetail(String name, String price, String count, String sugar, String orderIn, String id, String time) {

        this.name = name;
        this.price = price;
        this.count = count;
        this.sugar = sugar;
        this.orderIn = orderIn;
        this.id = id;
        this.time = time;
    }

    private String time;

    public SmoothieDetail(String name, String price, String count, String sugar, String orderIn, String id) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.sugar = sugar;
        this.orderIn = orderIn;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getOrderIn() {
        return orderIn;
    }

    public void setOrderIn(String orderIn) {
        this.orderIn = orderIn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
