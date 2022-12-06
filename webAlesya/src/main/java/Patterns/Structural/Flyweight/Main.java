package Patterns.Structural.Flyweight;

import java.util.ArrayList;
import java.util.List;

import static Patterns.Structural.Flyweight.SPECIALTY.CPP;
import static Patterns.Structural.Flyweight.SPECIALTY.JAVA;

public class Main {
    public static void main(String[] args) {

        DeveloperFactory factory = new DeveloperFactory();
        List<Developer> developers = new ArrayList<>();
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(JAVA));
        developers.add(factory.getDeveloperBySpecialty(CPP));
        developers.add(factory.getDeveloperBySpecialty(CPP));
        developers.add(factory.getDeveloperBySpecialty(CPP));
        developers.add(factory.getDeveloperBySpecialty(CPP));
        for (Developer developer : developers) {
            developer.writeCode();
        }


    }
}
