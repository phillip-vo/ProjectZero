package com.revature.model;

public class Runner {
    private String name;
    private int runner_id;

    public Runner(String name, int runner_id) {
        this.name = name;
        this.runner_id = runner_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunner_id() {
        return runner_id;
    }

    public void setRunner_id(int runner_id) {
        this.runner_id = runner_id;
    }

    @Override
    public String toString() {
        return "Runner{" + "name='" + name + '\'' + ", runner_id=" + runner_id + "}";
    }
}
