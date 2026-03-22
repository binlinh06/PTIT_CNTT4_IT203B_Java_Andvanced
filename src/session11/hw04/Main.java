package session11.hw04;

public class Main {
    public static void main(String[] args) {

        PatientDAO dao = new PatientDAO();

        System.out.println("=== Test SQL Injection (cách lọc) ===");
        dao.searchPatientUnsafe("' OR '1'='1");

        System.out.println("\n=== Cách an toàn (PreparedStatement) ===");
        dao.searchPatientSafe("' OR '1'='1");
    }
}