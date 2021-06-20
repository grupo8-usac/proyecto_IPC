package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Productos implements Serializable {
    public int id;
    public String name;
    public String description;
    public int cost;
    public int price;
    public ArrayList<Ingredientes> ingredients;

    public Productos(int id, String name, String description, int cost, int price, ArrayList<Ingredientes> ingredients) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.price = price;
        this.ingredients = ingredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Ingredientes> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredientes> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public  String  toString(){
        return "Id:"+id+"\tName:"+name+"\tDescription:"+description+"\tCost:"+cost+"\tPrice:"+price+"\n";
    }

}

