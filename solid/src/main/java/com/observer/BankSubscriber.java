package com.observer;

import java.util.Observable;
import java.util.Observer;

public class BankSubscriber implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("bank updated address " + arg);
    }

}
