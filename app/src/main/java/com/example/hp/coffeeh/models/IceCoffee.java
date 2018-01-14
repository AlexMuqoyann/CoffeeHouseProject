package com.example.hp.coffeeh.models;

/**
 * Created by HP on 13.11.2017.
 */

public class IceCoffee {
    private String name;
    private String price;
    private String image;
    private String menuId;
    private String rowPrice;
    public String getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(String rowPrice) {
        this.rowPrice = rowPrice;
    }



    public IceCoffee(String name, String price, String image, String menuId,String rowPrice) {
        this.rowPrice = rowPrice;
        this.name = name;
        this.price = price;
        this.image = image;
        this.menuId = menuId;
    }

    public IceCoffee() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }


}
