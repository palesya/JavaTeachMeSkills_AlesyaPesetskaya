package Homework_7.Jobs.Implementation;

import Homework_7.Jobs.Printable;

public class Employee implements Printable {

    private String job;

    public Employee(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public void print() {
        System.out.println("This is an employee - "+this.getJob());
    }
}
