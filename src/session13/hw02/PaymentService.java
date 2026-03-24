package session13.hw02;

import java.sql.Connection;

public class PaymentService {

    private WalletDAO walletDAO = new WalletDAO();
    private InvoiceDAO invoiceDAO = new InvoiceDAO();

    public void payInvoice(int patientId, int invoiceId, double amount) {

        Connection conn = null;

        try {
            conn = DBContext.getConnection();

            // Bắt đầu transaction
            conn.setAutoCommit(false);

            // 1. Trừ tiền
            int r1 = walletDAO.deductMoney(conn, patientId, amount);
            if (r1 == 0) {
                throw new Exception("Không đủ tiền hoặc không tồn tại ví!");
            }

            // 2. Cập nhật hóa đơn
            int r2 = invoiceDAO.markAsPaid(conn, invoiceId);
            if (r2 == 0) {
                throw new Exception("Không tìm thấy hóa đơn!");
            }

            // Thành công → commit
            conn.commit();
            System.out.println("Thanh toán thành công!");

        } catch (Exception e) {

            /*
             * PHẦN QUAN TRỌNG NHẤT CỦA BÀI
             *
             * BẮT BUỘC phải rollback khi có lỗi
             */
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback do lỗi!");
                } catch (Exception rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }

            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // reset
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}