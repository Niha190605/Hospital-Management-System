import dao.PatientDAO;

public class DisplayPatients {

    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        dao.getAllPatients();
    }
}