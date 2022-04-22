package Lecture_7.Employee;

public class Manager extends Employee {
    private double bonus;
    public Manager(String name, String position, double salary,double bonus) {
        super(name, position, salary);
        this.bonus=bonus;
    }

    @Override
    public String getDescription() {
        return "Hello, I am a manager";
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void raiseSalary(double percent) {
        double raise = this.salary * percent / 100;
        this.salary += raise+this.bonus;
    }
}
