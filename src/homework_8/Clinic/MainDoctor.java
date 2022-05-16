package homework_8.Clinic;

public class MainDoctor {
    public static void main(String[] args) {
        Doctor dentist = new Dentist("Ivanov", 123);
        Doctor surgeon = new Surgeon("Petrov", 111);
        Doctor therapist = new Therapist("Sidorov", 101);
        Patient patient = new Patient("Annina", new int[]{1, 8});
        Doctor[] doctors = {dentist, surgeon,therapist};
        appointDoctor(patient, doctors);
    }

    public static void appointDoctor(Patient patient, Doctor[] doctors) {
        int[] treatmentPlan = patient.getTreatmentPlan();
        System.out.println("According to your treatment plan, you should visit: ");
        int numberOfSurgeons = 0;
        int numberOfDentists = 0;
        int numberOfTherapist = 0;
        for (Doctor doc : doctors) {
            if (doc instanceof Dentist) {
                numberOfDentists++;
            }
            if (doc instanceof Surgeon) {
                numberOfSurgeons++;
            }
            if (doc instanceof Therapist) {
                numberOfTherapist++;
            }
        }
        for (int plan : treatmentPlan)
            switch (plan) {
                case 1:
                    System.out.println("- a surgeon ");
                    if (numberOfSurgeons == 0) {
                        System.out.println("But no surgeon is available now.");
                    } else {
                        for (Doctor doc : doctors) {
                            if (doc instanceof Surgeon) {
                                doc.heal();
                                System.out.println(doc);
                            }
                        }
                    }
                    continue;
                case 2:
                    System.out.println("- a dentist ");
                    if (numberOfDentists == 0) {
                        System.out.println("But no dentist is available now.");
                    }else {
                        for (Doctor doc : doctors) {
                            if (doc instanceof Dentist) {
                                doc.heal();
                                System.out.println(doc);
                            }
                        }
                    }
                    continue;
                default:
                    System.out.println("- a therapist ");
                    if (numberOfTherapist == 0) {
                        System.out.println("but no therapist is available now.");
                    }else {
                        for (Doctor doc : doctors) {
                            if (doc instanceof Therapist) {
                                doc.heal();
                                System.out.println(doc);
                            }
                        }
                    }
            }
    }
}



