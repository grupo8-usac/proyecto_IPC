package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Facturas implements Serializable {
    public int id;
    public int client ;
    public String date;
    public int phone;
    public ArrayList<Products> products;

    public Facturas(int id, int client, String date, int phone,ArrayList<Products> products) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.phone = phone;
        this.products = products;
    }

    public ArrayList<Products> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Products> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    @Override
    public  String  toString(){
        return "Id:"+id+"\tCliente:"+client+"\tDate:"+date+"\tPhone:"+phone+"\n";
    }
}
