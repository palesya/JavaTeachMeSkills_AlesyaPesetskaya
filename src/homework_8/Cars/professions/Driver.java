package homework_8.Cars.professions;

import homework_8.Cars.common.Person;

public class Driver extends Person {
    private int yearsOfPractice;

    public Driver(String name, int yearsOfPractice) {
        super(name);
        this.yearsOfPractice = yearsOfPractice;
    }

    public Driver() {
    }

    public int getYearsOfPractice() {
        return yearsOfPractice;
    }

    public void setYearsOfPractice(int yearsOfPractice) {
        this.yearsOfPractice = yearsOfPractice;
    }


}
