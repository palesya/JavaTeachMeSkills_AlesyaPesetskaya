package Homework_8.Clinic;

public class Dentist extends Doctor{

    public Dentist(String name, int cabinetNumber) {
        super(name, cabinetNumber);
    }

    @Override
    void heal() {
        System.out.println("Dentist checks teeth.");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
