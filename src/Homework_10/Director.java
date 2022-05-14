package Homework_10;

import java.util.Arrays;
import java.util.Comparator;

public class Director extends Employee {

    protected int numberOfSubordinates;
    protected Employee[] listOfSubordinates;

    public Director(String name, String secondName, int workExperience) {
        super(name, secondName, workExperience);
        this.position = Position.DIRECTOR;
        this.listOfSubordinates = new Employee[0];
    }

    @Override
    public void calculateSalary() {
        double salary = (this.workExperience / 10d + 1) * this.position.coefficient * baseRate * (this.numberOfSubordinates / 10d + 1);
        System.out.println(String.join(" ", "The salary of", getFullNameAndPosition(), "=", String.format("%.0f", salary)));
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void printNumberOfSubordinates() {
        System.out.printf("The number of subordinates of %s %s = %d", name, secondName, this.getNumberOfSubordinates());
        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

    public Employee[] setSubordinates(Employee employee) {
        listOfSubordinates = Arrays.copyOf(listOfSubordinates, listOfSubordinates.length + 1);
        for (int i = 0; i < listOfSubordinates.length; i++) {
            if (listOfSubordinates[i] == null) {
                listOfSubordinates[i] = employee;
                this.numberOfSubordinates += 1;
                break;
            }
        }
        Arrays.sort(listOfSubordinates, Comparator.comparing(Employee::getPosition).reversed());
        return listOfSubordinates;
    }

    public void printAllSubordinates() {
        System.out.println("---------------------------------------------------------");
        System.out.println("The list of all subordinates of " + this.getName() + " " + this.getSecondName() + ":");
        for (Employee el : listOfSubordinates) {
            if (el instanceof Worker) {
                System.out.println(String.join(" ", "- ", el.getFullNameAndPosition()));
            } else if (el instanceof Director) {
                System.out.println(String.join(" ", "- ", el.getFullNameAndPosition()));
                ((Director) el).printAllSubordinates();
            }
        }
        if (this.listOfSubordinates.length == 0) {
            System.out.println("- no subordinates");
        }
    }

    public Employee[] getListOfSubordinates() {
        return listOfSubordinates;
    }



}
