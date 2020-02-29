package com.example.findv2;

public class Worker {

    String Name;
    float Mobile;
    float Rating;


    public Worker(){

    }

    public Worker(String Name, float Mobile, float Rating) {
        this.Name = Name;
        this.Mobile = Mobile;
        this.Rating = Rating;

    }

    public String getName() {
        return Name;
    }

    public float getMobile() { return Mobile;}

    public float getRating() {
        return Rating;
    }


}
