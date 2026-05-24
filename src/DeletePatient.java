import dao.PatientDAO;

public class DeletePatient {

    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        dao.deletePatient(101);
    }
}