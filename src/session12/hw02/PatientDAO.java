package session12.hw02;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PatientDAO {

    public void updateVitals(int id, double temperature, int heartRate) {

        String sql = "UPDATE Patients_Vitals SET temperature = ?, heart_rate = ? WHERE patient_id = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            // 🔥 set đúng kiểu dữ liệu
            ps.setDouble(1, temperature);
            ps.setInt(2, heartRate);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Cập nhật thành công!");
            } else {
                System.out.println("Không tìm thấy bệnh nhân!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
