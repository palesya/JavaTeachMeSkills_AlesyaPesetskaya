package lecture_7.Employee;

public class Student extends Person {
    @Override
    public String getDescription() {
        return "Hello, I am a student";
    }

    @Override
    public void walk() {
        System.out.println("I am going to the university");
    }
}
