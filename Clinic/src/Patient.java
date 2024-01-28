public class Patient {
    private TreatmentPlan treatmentPlan;

    public Patient(TreatmentPlan treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public void appointDoctor() {
        Doctor doctor;
        if (treatmentPlan.getCode() == 1) {
            doctor = new Surgeon();
        } else if (treatmentPlan.getCode() == 2) {
            doctor = new Dentist();
        } else {
            doctor = new Therapist();
        }
        doctor.treat();
    }
}
