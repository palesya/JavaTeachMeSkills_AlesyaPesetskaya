package Lecture_7.Implementation;

import Lecture_7.Examples.Flyable;

public class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane flies.");
    }
}
