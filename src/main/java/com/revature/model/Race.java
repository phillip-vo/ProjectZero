package com.revature.model;

public class Race {
    private String name;
    private int race_id;
    private String distance;

    public Race(String name, int race_id, String distance) {
        this.name = name;
        this.race_id = race_id;
        this. distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Race{" + "name='" + name + '\'' + ", race_id=" + race_id + ", distance=" + distance + "}";
    }
}
