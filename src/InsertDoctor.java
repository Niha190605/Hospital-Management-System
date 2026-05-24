import dao.DoctorDAO;
import model.Doctor;

public class InsertDoctor {

    public static void main(String[] args) {

        Doctor d1 =
                new Doctor(
                        1,
                        "Dr. Sharma",
                        "Cardiologist"
                );

        DoctorDAO dao = new DoctorDAO();

        dao.addDoctor(d1);
    }
}