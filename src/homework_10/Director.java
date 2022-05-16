package homework_10;

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
    public double calculateSalary() {
        double salary = (this.workExperience / 10d + 1) * this.position.coefficient * baseRate * (this.numberOfSubordinates / 10d + 1);
        System.out.println(String.join(" ", "The salary of", getFullNameAndPosition(), "=", String.format("%.0f", salary)));
        return salary;
    }

    public int getNumberOfSubordinates() {
        return numberOfSubordinates;
    }

    public void printNumberOfSubordinates() {
        System.out.printf("The number of subordinates of %s %s = %d", name, secondName, this.getNumberOfSubordinates());
        System.out.println();
        System.out.println("---------------------------------------------------------");
    }

    public Employee[] addSubordinate(Employee employee) {
        listOfSubordinates = Arrays.copyOf(listOfSubordinates, listOfSubordinates.length + 1);
        listOfSubordinates[listOfSubordinates.length - 1] = employee;
        this.numberOfSubordinates += 1;
        Arrays.sort(listOfSubordinates, Comparator.comparing(Employee::getPosition).reversed());
        return listOfSubordinates;
    }

    public void printAllSubordinates() {
        System.out.println("---------------------------------------------------------");
        System.out.println("The list of all subordinates of " + this.getName() + " " + this.getSecondName() + ":");
        System.out.println(Arrays.toString(listOfSubordinates));
        Employee lastEmployeeInList = listOfSubordinates[listOfSubordinates.length - 1];
        if (lastEmployeeInList instanceof Director) {
            ((Director) lastEmployeeInList).printAllSubordinates();
        }
        if (this.listOfSubordinates.length == 0) {
            System.out.println("- no subordinates");
        }
    }

    public Employee[] getListOfSubordinates() {
        return listOfSubordinates;
    }


}
