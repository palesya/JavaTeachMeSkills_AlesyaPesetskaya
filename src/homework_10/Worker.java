package homework_10;

public class Worker extends Employee {
    public Worker(String name, String secondName, int workExperience) {
        super(name, secondName, workExperience);
        this.position = Position.WORKER;
    }

}
