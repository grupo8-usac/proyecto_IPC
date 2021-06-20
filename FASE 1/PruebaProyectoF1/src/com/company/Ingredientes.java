package com.company;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Ingredientes implements Serializable {
    public String name;
    public int quantity;
    public String units;

    public Ingredientes(String name, int quantity, String units) {
        this.name = name;
        this.quantity = quantity;
        this.units = units;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }


    @Override
    public  String  toString(){
        return "Name:"+name+"\tquantity:"+quantity+"\tunits:"+units+"";
    }


}
