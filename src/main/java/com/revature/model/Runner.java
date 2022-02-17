package com.revature.model;

public class Runner {
    private int runner_id;
    private String name;

    public Runner(String name, int runner_id) {
        this.runner_id = runner_id;
        this.name = name;
    }

    public int getRunner_id() {
        return runner_id;
    }

    public void setRunner_id(int runner_id) {
        this.runner_id = runner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Runner{" + "runner_id='" + runner_id + '\'' + ", name=" + name + "}";
    }
}
