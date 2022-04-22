package Homework_7.Jobs.Implementation;

import Homework_7.Jobs.Printable;

public class Accountant implements Printable {

    private String degree;

    public Accountant(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    @Override
    public void print() {
        System.out.println("This is a "+this.getDegree()+" accountant");
    }
}
