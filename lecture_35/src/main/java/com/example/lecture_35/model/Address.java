package com.example.lecture_35.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private int home;

    public Address() {
    }

    public Address(String city, int home) {
        this.city = city;
        this.home = home;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", home=" + home +
                '}';
    }
}
