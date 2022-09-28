package com.observer;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SchoolSubscriber schoolSubscriber = new SchoolSubscriber();
        BankSubscriber bankSubscriber = new BankSubscriber();
        Passport passport = new Passport("133443",new Date(),"Minsk");
        passport.addObserver(schoolSubscriber);
        passport.addObserver(bankSubscriber);
        passport.setAddress("New York");

    }
}
