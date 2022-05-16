package homework_8.Clinic;

public class Patient {

    private String name;
    private int[] treatmentPlan;

    public Patient(String name, int[] treatmentPlan) {
        this.name = name;
        this.treatmentPlan = treatmentPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(int[] treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }
}
