package com.company;

import java.io.Serializable;

public class Products implements Serializable {
    public String name;
    public int price;

    public Products(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public  String  toString(){
        return "Name:"+name+"\tPrice:"+price+"";
    }
}
