package session13.hw02;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WalletDAO {

    public int deductMoney(Connection conn, int patientId, double amount) throws Exception {
        String sql = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ? AND balance >= ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setDouble(1, amount);
        ps.setInt(2, patientId);
        ps.setDouble(3, amount);

        return ps.executeUpdate();
    }
}
