package com.company;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Vector;

public class Usuarios implements Serializable {
    public String username;
    public String password;

    public Usuarios(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public  String  toString(){
        return "Username:"+username+"\tPassword:"+password+ "\n";
    }

}
