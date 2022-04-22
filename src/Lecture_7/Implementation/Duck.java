package Lecture_7.Implementation;

import Lecture_7.Examples.Flyable;
import Lecture_7.Examples.Noisable;

public class Duck implements Flyable, Noisable {
    @Override
    public void fly() {
        System.out.println("I am simple duck and i can fly");
    }
}
