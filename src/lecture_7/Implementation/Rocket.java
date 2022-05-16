package lecture_7.Implementation;

import lecture_7.Examples.Flyable;
import lecture_7.Examples.Noisable;

public class Rocket implements Flyable, Noisable {
    @Override
    public void fly() {
        System.out.println("Rocket also can fly. But to space!!!");
    }

    @Override
    public void makeSomeNoise() {
        System.out.println("Rocket makes really loud noise");
    }
}
