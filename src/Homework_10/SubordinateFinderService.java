package Homework_10;

import java.util.Objects;

public class SubordinateFinderService {

    private int numberOfFoundSubordinates;

    public void find(Director director, String name) {
        for (Employee el : director.listOfSubordinates) {
            if (el instanceof Worker) {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    numberOfFoundSubordinates+=1;
                }
            } else {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    numberOfFoundSubordinates+=1;
                }
                find(((Director) el), name);
            }
        }
        if (numberOfFoundSubordinates == 0) {
            System.out.println("No subordinates found with name " + name);
        }
    }

}
