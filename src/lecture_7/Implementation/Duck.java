package lecture_7.Implementation;

import lecture_7.Examples.Flyable;
import lecture_7.Examples.Noisable;

public class Duck implements Flyable, Noisable {
    @Override
    public void fly() {
        System.out.println("I am simple duck and i can fly");
    }
}
