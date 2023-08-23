package com.example.ispitt;

import java.io.Serializable;

public class Hero implements Serializable {
    private int id;
    private String username;
    private String password;
    private String type;


    public Hero(int id,String username, String password,String type) {
        this.username = username;
        this.password = password;
        this.id=id;
        this.type=type;

    }


    public String getUsername() {
        return username;
    }
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }




}
