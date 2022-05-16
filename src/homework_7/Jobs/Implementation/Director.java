package homework_7.Jobs.Implementation;

import homework_7.Jobs.Printable;

public class Director implements Printable {

    private String department;

    public String getDepartment() {
        return department;
    }

    public Director(String department) {
        this.department = department;
    }

    @Override
    public void print() {
        System.out.println("This is a director of "+this.getDepartment());
    }
}
