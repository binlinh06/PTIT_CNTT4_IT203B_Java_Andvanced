package session11.hw04;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class PatientDAO {

    /*
     * ================= PHẦN 1 - PHÂN TÍCH =================
     *
     * Input hacker:
     *   ' OR '1'='1
     *
     * SQL sau khi nối:
     *   SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
     *
     * Vì '1'='1' luôn đúng → WHERE luôn đúng
     * => Trả về toàn bộ dữ liệu → lộ thông tin
     */

    // ================= PHẦN 2 - CÁCH 1: LỌC INPUT =================
    public String sanitizeInput(String input) {
        if (input == null) return "";

        input = input.replace("'", "");
        input = input.replace("--", "");
        input = input.replace(";", "");

        return input;
    }

    public void searchPatientUnsafe(String name) {
        name = sanitizeInput(name);

        String sql = "SELECT * FROM Patients WHERE full_name = '" + name + "'";

        try (
                Connection conn = DBContext.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
        ) {

            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("full_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ================= CÁCH 2 - CHUẨN (PreparedStatement) =================
    public void searchPatientSafe(String name) {

        String sql = "SELECT * FROM Patients WHERE full_name = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Tên: " + rs.getString("full_name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
