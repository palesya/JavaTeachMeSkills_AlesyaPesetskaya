package homework_10;

import java.util.Objects;

public class SubordinateFinderService {

    private boolean isFound;

    public void find(Director director, String name) {
        for (Employee el : director.listOfSubordinates) {
            if (el instanceof Worker) {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    isFound=true;
                }
            } else {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    isFound=true;
                }
                find(((Director) el), name);
            }
        }
        if (!isFound) {
            System.out.println("No subordinates found with name " + name);
        }
    }

}
