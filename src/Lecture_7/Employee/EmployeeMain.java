package Lecture_7.Employee;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee employee=new Employee("Vasya","frontend developer",1000);
        System.out.println(employee);
        employee.raiseSalary(50);
        System.out.println("New salary employee "+employee.getSalary());
        System.out.println("---------------------------");
        Manager manager=new Manager("Petya","PM",2000,10000);
        System.out.println(manager);
        manager.raiseSalary(50);
        System.out.println("New salary manager "+manager.getSalary());
        System.out.println("---------------------------");
        Student student=new Student();
        System.out.println(employee.getDescription());
        System.out.println(manager.getDescription());
        System.out.println(student.getDescription());
        System.out.println("---------------------------");
        employee.walk();
        manager.walk();
        student.walk();
        Person person=new Employee("Anna","DEV",3000);
        System.out.println(person.getDescription());
    }
}
