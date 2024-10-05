package com.example.prac03;

import java.io.Serializable;

public class    Country implements Serializable{
    private String name;
    private String capital;
    private int flagResourceId;
    private long population;
    private long area;
    private double density;
    private double worldShare;

    public Country(String name, String capital, int flagResourceId, long population, long area, double density, double worldShare) {
        this.name = name;
        this.capital = capital;
        this.flagResourceId = flagResourceId;
        this.population = population;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    // Getters
    public String getName() { return name; }
    public String getCapital() { return capital; }
    public int getFlagResourceId() { return flagResourceId; }
    public long getPopulation() { return population; }
    public long getArea() { return area; }
    public double getDensity() { return density; }
    public double getWorldShare() { return worldShare; }
}


