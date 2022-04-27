package Homework_8.Clinic;

public class Surgeon extends Doctor{
    public Surgeon(String name, int cabinetNumber) {
        super(name, cabinetNumber);
    }

    @Override
    void heal() {
        System.out.println("Surgeon performs surgery.");
    }

}
