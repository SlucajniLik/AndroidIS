package com.example.ispitt;

import java.io.Serializable;

public class Job implements Serializable {
    private int id;
    private String name;
    private String number;
    private String type;


    public Job(String name, String number, String type) {
        this.name = name;
        this.number = number;
        this.type = type;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }






}
