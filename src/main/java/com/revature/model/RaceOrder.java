package com.revature.model;

public class RaceOrder {
    private int orderId;
    private int runnerId;
    private int raceId;

    public RaceOrder(int orderId, int runnerId, int raceId) {
        this.orderId = orderId;
        this.runnerId = runnerId;
        this.raceId = raceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(int runnerId) {
        this.runnerId = runnerId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    @Override
    public String toString() {
        return "RaceOrder{" + "orderId='" + orderId + '\'' +
                ", runnerId='" + runnerId + '\'' +
                ", raceId='" + raceId + '\'' + "}";
    }
}
