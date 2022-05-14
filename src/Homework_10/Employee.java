package Homework_10;

public abstract class Employee implements CalculateSalary{
    protected String name;
    protected String secondName;
    protected int workExperience;
    protected Position position;
    protected final int baseRate=1000;

    public Employee(String name, String secondName, int workExperience) {
        this.name = name;
        this.secondName = secondName;
        this.workExperience = workExperience;
    }

    public Employee(String name, String secondName, int workExperience, Position position) {
        this.name = name;
        this.secondName = secondName;
        this.workExperience = workExperience;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getBaseRate() {
        return baseRate;
    }

    protected String getFullNameAndPosition(){
        return String.join(" ",position.toString().toLowerCase(),name,secondName);
    }
}
