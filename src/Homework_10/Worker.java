package Homework_10;

public class Worker extends Employee {
    public Worker(String name, String secondName, int workExperience) {
        super(name, secondName, workExperience);
        this.position = Position.WORKER;
    }

    @Override
    public void calculateSalary() {
        double salary = (this.workExperience / 10d + 1) * this.position.coefficient * baseRate;
        System.out.println(String.join(" ","The salary of",getFullNameAndPosition(),"=",String.format("%.0f",salary)));
    }
}
