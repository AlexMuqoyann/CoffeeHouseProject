package com.example.hp.coffeeh.models;



public class University {
    private String workTime;
    private String name;
    private int image;

    public University(){

    }

    public University(String workTime, String name, int image) {

        this.workTime = workTime;
        this.name = name;
        this.image = image;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
