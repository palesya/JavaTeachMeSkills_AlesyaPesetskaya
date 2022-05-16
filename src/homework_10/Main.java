package homework_10;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Ivan", "Ivanov", 3);
        Worker worker2 = new Worker("Petya", "Petrov", 6);
        Worker worker3 = new Worker("Anna", "Nice", 1);
        Worker worker4 = new Worker("Elena", "Davidova", 3);
        Worker worker5 = new Worker("Pavel", "Good", 10);
        Director director1 = new Director("Alexey", "Sidorov", 12);
        Director director2 = new Director("Sergey", "Main", 10);
        Director director3 = new Director("Petya", "Pesetskiy", 5);
        Employee[] allEmployees={worker1,worker2,worker3,worker4,worker5,director1,director2,director3};
        for(Employee el:allEmployees){
            el.calculateSalary();
        }
        director1.addSubordinate(director2);
        director1.addSubordinate(worker1);
        director1.addSubordinate(worker2);
        director1.addSubordinate(worker3);
        director2.addSubordinate(worker4);
        director2.addSubordinate(director3);
        director3.addSubordinate(worker5);

        director1.printAllSubordinates();
        director2.printAllSubordinates();
        director3.printAllSubordinates();

        director1.printNumberOfSubordinates();
        director2.printNumberOfSubordinates();
        director3.printNumberOfSubordinates();

        SubordinateFinderService findSubordinate = new SubordinateFinderService();
        findSubordinate.find(director1,"Petya");
    }
}
