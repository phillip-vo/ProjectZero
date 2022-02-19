package com.revature.model;

public class Runner {
    private int runner_id;
    private String lastName;
    private String firstName;
    private String gender;
    private int age;
    private String address;
    private String city;
    private String state;
    private String postalCode;

    public Runner(int runner_id, String lastName, String firstName, String gender, int age) {

        this.runner_id = runner_id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;

    }

    public int getRunner_id() {
        return runner_id;
    }

    public void setRunner_id(int runner_id) {
        this.runner_id = runner_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "Runner{" + "runner_id=" + runner_id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age + "}";
    }
}
