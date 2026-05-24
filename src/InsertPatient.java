import dao.PatientDAO;
import model.Doctor;
import model.Patient;

public class InsertPatient {

    public static void main(String[] args) {

        Doctor d1 = new Doctor(
                1,
                "Dr. Sharma",
                "Cardiologist");

        Patient p1 = new Patient(
                101,
                "Riya",
                201,
                5,
                d1);

        PatientDAO dao = new PatientDAO();

        dao.addPatient(p1);
    }
}