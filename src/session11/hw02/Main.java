package session11.hw02;

public class Main {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        System.out.println("=== DANH MỤC THUỐC ===");
        dao.getAllMedicines();
    }
}
