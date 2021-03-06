package homework_16.task_2;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class FamilyService {

    public void printIfFamilyExistsWithChildName(List<Family> familiesList, String name) {
        int size = (int) familiesList
                .stream()
                .flatMap(fam -> fam.getListOfChildren().stream())
                .filter(el -> Objects.equals(el.getName(), name))
                .count();
        if (size > 0) {
            System.out.println("Family with child's name " + name + " is found.");
        } else {
            System.out.println("Family with child's name " + name + " is not found.");
        }
    }

    public void printFamilySNameWithChildName(List<Family> familiesList, String name) {
        List<String> collect = familiesList
                .stream()
                .filter(el -> checkIfNameIsFound(el, name))
                .map(Family::getSName).collect(Collectors.toList());
        if (collect.size() == 1) {
            System.out.println("Family with child's name " + name + " is found. It is family " + collect);
        } else if (collect.size() == 0) {
            System.out.println("Family with child's name " + name + " is not found.");
        } else {
            System.out.println("Families with child's name " + name + " are found. These are families: " + collect);
        }
    }

    private boolean checkIfNameIsFound(Family el, String name) {
        long count = el.getListOfChildren()
                .stream()
                .filter(n -> Objects.equals(n.getName(), name)).count();
        return count > 0;
    }

}
