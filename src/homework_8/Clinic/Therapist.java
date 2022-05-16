package homework_8.Clinic;

public class Therapist extends Doctor{

    public Therapist(String name, int cabinetNumber) {
        super(name, cabinetNumber);
    }

    @Override
    void heal() {
        System.out.println("Therapist performs examines.");
    }

}
