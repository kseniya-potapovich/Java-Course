public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient(new TreatmentPlan(5));
        patient.appointDoctor();
    }
}
