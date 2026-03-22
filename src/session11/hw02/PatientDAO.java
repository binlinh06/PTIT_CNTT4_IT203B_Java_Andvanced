package session11.hw02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PatientDAO {

    /*
     * PHẦN 1 - PHÂN TÍCH
     *
     * - if(rs.next()) chỉ chạy 1 lần → chỉ lấy 1 dòng
     * - ResultSet có con trỏ, mỗi lần next() sẽ xuống 1 dòng
     * - Muốn duyệt hết phải dùng while
     */

    public void getAllMedicines() {
        String sql = "SELECT medicine_name, stock FROM Pharmacy";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {

            // PHẦN 2 - THỰC THI (dùng while)
            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");

                System.out.println("Thuốc: " + name + " | Tồn kho: " + stock);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
