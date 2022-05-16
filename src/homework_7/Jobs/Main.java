package homework_7.Jobs;

import homework_7.Jobs.Implementation.Accountant;
import homework_7.Jobs.Implementation.Director;
import homework_7.Jobs.Implementation.Employee;

public class Main {
    public static void main(String[] args) {
        Accountant accountant = new Accountant("main");
        Director director = new Director("sales");
        Employee employee = new Employee("engineer");
       accountant.print();
       director.print();
       employee.print();
    }
}
