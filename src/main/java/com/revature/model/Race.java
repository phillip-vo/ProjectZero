package com.revature.model;

public class Race {
    private int raceId;
    private String name;
    private String distance;
    private String location;
    private String city;
    private String state;
    private String postalCode;

    public Race(int raceId, String name, String distance) {
        this.raceId = raceId;
        this.name = name;
        this.distance = distance;
    }

    public Race(String name, String distance) {

    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
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
        return "Race{" + "race_id='" + raceId + '\'' + ", name=" + name + ", distance=" + distance + "}";
    }
}
