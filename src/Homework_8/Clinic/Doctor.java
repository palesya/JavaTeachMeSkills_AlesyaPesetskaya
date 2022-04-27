package Homework_8.Clinic;

public abstract class Doctor {

    protected String name;
    protected int cabinetNumber;

    public Doctor(String name, int cabinetNumber) {
        this.name = name;
        this.cabinetNumber = cabinetNumber;
    }

    abstract void heal();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCabinetNumber() {
        return cabinetNumber;
    }

    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }

    @Override
    public String toString() {
        return "This is doctor " + this.getName() +
                " cabinet number = " + this.getCabinetNumber();
    }
}
