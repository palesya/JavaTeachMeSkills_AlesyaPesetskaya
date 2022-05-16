package lecture_7.Implementation;

import lecture_7.Examples.Flyable;

public class Plane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Plane flies.");
    }
}
