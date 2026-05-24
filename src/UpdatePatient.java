import dao.PatientDAO;

public class UpdatePatient {

    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        dao.updateRoom(101, 301);
    }
}