package Patterns.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

public class DeveloperFactory {

    private final Map<String, Developer> developers = new HashMap<>();

    public Developer getDeveloperBySpecialty(SPECIALTY specialty) {
        Developer developer = developers.get(String.valueOf(specialty));
        if (developer == null) {
            switch (specialty) {
                case CPP:
                    System.out.println("Hiring C++ developer");
                    developer = new CppDeveloperImpl();
                    break;
                case JAVA:
                    System.out.println("Hiring Java developer");
                    developer = new JavaDeveloperImpl();
                    break;
            }
            developers.put(String.valueOf(specialty), developer);
        }
        return developer;
    }


}
