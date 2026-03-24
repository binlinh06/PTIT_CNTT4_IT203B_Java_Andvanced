package session13.hw01;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MedicineDAO {

    // Trừ thuốc
    public int decreaseMedicine(Connection conn, int medicineId) throws Exception {
        String sql = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ? AND quantity > 0";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, medicineId);

        return ps.executeUpdate();
    }
}