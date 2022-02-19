package com.revature.model;

public class Runner {
    private int runnerId;
    private String lastName;
    private String firstName;
    private String gender;
    private int age;
    private String address;
    private String city;
    private String state;
    private String postalCode;

    public Runner(int runnerId, String lastName, String firstName, String gender, int age) {
        this.runnerId = runnerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
    }

    public Runner(String lastName, String firstName, String gender, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.age = age;
    }

    public int getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(int runnerId) {
        this.runnerId = runnerId;
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
        return "Runner{" + "runner_id='" + runnerId + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age + "}";
    }
}
