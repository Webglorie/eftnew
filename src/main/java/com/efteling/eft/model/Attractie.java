package com.efteling.eft.model;

public class Attractie {
    private int id;
    private String naam;
    private int minLeeftijd;
    private int minLengte;
    private int maxLengte;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getMinLeeftijd() {
        return minLeeftijd;
    }

    public void setMinLeeftijd(int minLeeftijd) {
        this.minLeeftijd = minLeeftijd;
    }

    public int getMinLengte() {
        return minLengte;
    }

    public void setMinLengte(int minLengte) {
        this.minLengte = minLengte;
    }

    public int getMaxLengte() {
        return maxLengte;
    }

    public void setMaxLengte(int maxLengte) {
        this.maxLengte = maxLengte;
    }
}
