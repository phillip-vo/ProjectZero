package com.revature.model;

public class Race {
    private int race_id;
    private String name;
    private String distance;

    public Race(String name, int race_id, String distance) {
        this.race_id = race_id;
        this.name = name;
        this. distance = distance;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Race{" + "race_id='" + race_id + '\'' + ", name=" + name + ", distance=" + distance + "}";
    }
}
