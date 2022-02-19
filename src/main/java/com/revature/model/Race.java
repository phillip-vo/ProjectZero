package com.revature.model;

public class Race {
    private int race_id;
    private String name;
    private String distances;
    private String location;
    private String city;
    private String state;
    private String postalCode;

    public Race(int race_id, String name, String distances) {
        this.race_id = race_id;
        this.name = name;
        this.distances = distances;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistances() {
        return distances;
    }

    public void setDistances(String distance) {
        this.distances = distances;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Race{" + "race_id='" + race_id + '\'' + ", name=" + name + ", distance=" + distances + "}";
    }
}
