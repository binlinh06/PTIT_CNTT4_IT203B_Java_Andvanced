package session13.hw01;

import java.sql.Connection;

public class PrescriptionService {

    private MedicineDAO medicineDAO = new MedicineDAO();
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    public void dispenseMedicine(int medicineId, int patientId) {

        Connection conn = null;

        try {
            conn = DBContext.getConnection();

            // Tắt auto-commit để bắt đầu transaction
            conn.setAutoCommit(false);

            // 1. Trừ thuốc
            int rows1 = medicineDAO.decreaseMedicine(conn, medicineId);

            if (rows1 == 0) {
                throw new Exception("Hết thuốc hoặc không tồn tại!");
            }

            // 2. Lưu lịch sử
            int rows2 = prescriptionDAO.insertHistory(conn, medicineId, patientId);

            if (rows2 == 0) {
                throw new Exception("Không lưu được lịch sử!");
            }

            // Thành công → commit
            conn.commit();
            System.out.println("Cấp phát thuốc thành công!");

        } catch (Exception e) {
            try {
                // Lỗi → rollback toàn bộ
                if (conn != null) {
                    conn.rollback();
                    System.out.println("Rollback do lỗi!");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // best practice
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}