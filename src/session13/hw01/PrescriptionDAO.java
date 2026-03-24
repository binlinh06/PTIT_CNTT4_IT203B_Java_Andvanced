package session13.hw01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PrescriptionDAO {

    // Lưu lịch sử cấp phát
    public int insertHistory(Connection conn, int medicineId, int patientId) throws Exception {
        String sql = "INSERT INTO Prescription_History (medicine_id, patient_id) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, medicineId);
        ps.setInt(2, patientId);

        return ps.executeUpdate();
    }
}