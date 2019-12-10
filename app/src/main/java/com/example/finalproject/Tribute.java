package com.example.finalproject;
//Tribute class


public class Tribute {

    private String name;
    private boolean status;
    private int district;
    private boolean used;
    private int kills;
    private int specialItems;

    public Tribute(String n, int d) {
        name = n;
        status = true;
        district = d;
        used = false;
        kills = 0;
        specialItems = 0;

    }
    public Tribute() {
        status = true;

    }
    public String getName() {
        return name;
    }
    public void setStatus() {
        status = false;
    }
    public int getDistrict() {
        return district;
    }
    public void setUsed() {
        used = true;
    }
    public void updateKills() {
        kills++;
    }
    public int getKills() {
        return kills;
    }
    public boolean getUsed() {
        return used;
    }
    public boolean getStatus() {
        return status;
    }
    public int getSpecialItems() {
        return specialItems;
    }
    public void updateSpecialItem() {
        specialItems++;
    }
    public void setName(String n) {
        name = n;
    }

}
