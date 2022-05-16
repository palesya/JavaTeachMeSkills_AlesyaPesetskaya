package lecture_7.Employee;

public class Employee extends Person {
    protected String name;
    protected String position;
    protected double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void raiseSalary(double percent) {
        double raise = this.salary * percent / 100;
        this.salary += raise;
        abuseManager();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private void abuseManager(){
        System.out.println("Bla bla bla");
    }

    @Override
    public String toString() {
        return "Employee with name " + name +
                "\nposition " + position +
                "\nsalary = " + salary;
    }

    @Override
    public String getDescription() {
        return "Hello, I am an employee";
    }
}
