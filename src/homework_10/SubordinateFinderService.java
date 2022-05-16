package homework_10;

import java.util.Objects;

public class SubordinateFinderService {

    private boolean isFound;

    public boolean find(Director director, String name) {
        for (Employee el : director.listOfSubordinates) {
            if (el.getPosition()==Position.WORKER) {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    isFound=true;
                    break;
                }
            } else {
                if (Objects.equals(name, el.name)) {
                    System.out.println(String.join(" ", "The subordinate with entered name", name, "is found.\nIt is", el.getFullNameAndPosition()));
                    isFound=true;
                    break;
                }
                find((Director) el, name);
            }
        }
        if (!isFound) {
            System.out.println("No subordinates found with name " + name);
        }
        return isFound;
    }

}
