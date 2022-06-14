package homework_16.task_2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static homework_16.task_2.Child.SEX.MAN;
import static homework_16.task_2.Child.SEX.WOMAN;

public class Main {
    public static void main(String[] args) {

        List<Family> familiesList = Arrays.asList(
                new Family("Ivanov", "Minsk, Angarskaya 30, 45", 500, Arrays.asList(
                        new Child("Ivan", 3, MAN),
                        new Child("Petya", 15, MAN),
                        new Child("Katya", 20, WOMAN)
                )),
                new Family("Petrov", "Borisov, Narodnaya 21,5", 627, Arrays.asList(
                        new Child("Alex", 2, MAN),
                        new Child("Alexandra", 7, WOMAN),
                        new Child("Oleg", 13, MAN)
                )),
                new Family("Sidorov", "Kopische, Nebesnaya 1,1", 2000, Arrays.asList(
                        new Child("Maxim", 25, MAN),
                        new Child("Marina", 30, WOMAN)
                ))
        );

        Map<String, Long> familiesMap = familiesList
                .stream()
                .collect(Collectors.toMap(Family::getSName, Family::getAverageSalaryPerMember));
        System.out.println("Map of families where key is surname and value is average salary per member:\n" + familiesMap);

        long sumOfBoys = familiesList.stream()
                .flatMap(fam -> fam.getListOfChildren().stream())
                .filter(child -> child.getSex() == MAN)
                .count();
        System.out.println("Number of boys in all families: " + sumOfBoys);

        List<Child> listOfGirls = familiesList.stream()
                .flatMap(fam -> fam.getListOfChildren().stream())
                .filter(child -> child.getSex() == WOMAN)
                .collect(Collectors.toList());
        System.out.println("List of all girls: \n" + listOfGirls);

        familiesList
                .forEach(el -> System.out.println("Number of children in family " + el.getSName() + " is: " + el.getListOfChildren().size()));

        FamilyService familyService = new FamilyService();

        familyService.printIfFamilyExistsWithChildName(familiesList, "Alex");
        familyService.printFamilySNameWithChildName(familiesList, "Alex");

    }


}
