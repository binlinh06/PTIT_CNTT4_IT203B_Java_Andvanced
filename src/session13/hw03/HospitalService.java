package session13.hw03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HospitalService {

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {

        Connection conn = null;

        try {
            conn = DBContext.getConnection();

            // Bắt đầu transaction
            conn.setAutoCommit(false);
            // 1. LẤY THÔNG TIN BỆNH NHÂN
            String getPatientSQL = "SELECT balance, bed_id FROM Patients WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(getPatientSQL);
            ps1.setInt(1, maBenhNhan);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                throw new Exception("Không tồn tại bệnh nhân!");
            }

            double balance = rs.getDouble("balance");
            int bedId = rs.getInt("bed_id");
            // BẪY 1: KHÔNG ĐỦ TIỀN
            if (balance < tienVienPhi) {
                throw new Exception("Không đủ tiền để thanh toán!");
            }
            // 2. TRỪ TIỀN
            String updateBalanceSQL = "UPDATE Patients SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(updateBalanceSQL);
            ps2.setDouble(1, tienVienPhi);
            ps2.setInt(2, maBenhNhan);

            int r1 = ps2.executeUpdate();
            // BẪY 2: ROW AFFECTED = 0
            if (r1 == 0) {
                throw new Exception("Trừ tiền thất bại!");
            }
            // 3. GIẢI PHÓNG GIƯỜNG
            String freeBedSQL = "UPDATE Beds SET status = 'EMPTY' WHERE bed_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(freeBedSQL);
            ps3.setInt(1, bedId);

            int r2 = ps3.executeUpdate();

            if (r2 == 0) {
                throw new Exception("Không tìm thấy giường!");
            }
            // 4. CẬP NHẬT BỆNH NHÂN
            String updatePatientSQL = "UPDATE Patients SET status = 'DISCHARGED' WHERE patient_id = ?";
            PreparedStatement ps4 = conn.prepareStatement(updatePatientSQL);
            ps4.setInt(1, maBenhNhan);

            int r3 = ps4.executeUpdate();

            if (r3 == 0) {
                throw new Exception("Update trạng thái thất bại!");
            }
            conn.commit();
            System.out.println("Xuất viện thành công!");

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback do lỗi!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            e.printStackTrace();

        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}