package session13.hw02;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InvoiceDAO {

    public int markAsPaid(Connection conn, int invoiceId) throws Exception {
        String sql = "UPDATE Invoices SET status = 'PAID' WHERE invoice_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, invoiceId);

        return ps.executeUpdate();
    }
}