package com.example.gift_tracker;

public class Gift {

    int id;
    String name;
    String description;

    public Gift(int giftId, String giftName, String giftDescription) {
        this.id = giftId;
        this.name = giftName;
        this.description = giftDescription;
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



}
