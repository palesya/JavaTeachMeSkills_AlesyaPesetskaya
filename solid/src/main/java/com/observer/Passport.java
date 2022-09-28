package com.observer;

import java.util.Date;
import java.util.Observable;

public class Passport extends Observable {

    private String pinfl;
    private Date expiration;
    private String address;

    public Passport(String pinfl, Date expiration, String address) {
        this.pinfl = pinfl;
        this.expiration = expiration;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
        setChanged();
        notifyObservers(address);
    }
}
