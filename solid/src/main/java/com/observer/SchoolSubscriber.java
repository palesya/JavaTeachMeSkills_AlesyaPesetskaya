package com.observer;

import java.util.Observable;
import java.util.Observer;

public class SchoolSubscriber implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("school updated address" + arg);
    }

}
