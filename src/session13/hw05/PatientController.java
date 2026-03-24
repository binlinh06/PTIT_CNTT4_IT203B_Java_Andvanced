package session13.hw05;

import java.sql.*;

public class PatientController {

    public void showEmptyBeds() {
        try (Connection conn = DBContext.getConnection()) {
            String sql = "SELECT * FROM Beds WHERE status = 'EMPTY'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Giường: " + rs.getInt("bed_id"));
            }
        } catch (Exception e) {
            System.out.println("Lỗi DB!");
        }
    }

    public void addPatient(String name, int age, int bedId, double money) {

        Connection conn = null;

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);
            // 1. CHECK GIƯỜNG
            String checkBed = "SELECT status FROM Beds WHERE bed_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(checkBed);
            ps1.setInt(1, bedId);

            ResultSet rs = ps1.executeQuery();

            if (!rs.next() || !rs.getString("status").equals("EMPTY")) {
                throw new Exception("Giường không hợp lệ!");
            }
            // 2. INSERT PATIENT
            String insertPatient = "INSERT INTO Patients(name, age, bed_id) VALUES (?, ?, ?)";
            PreparedStatement ps2 = conn.prepareStatement(insertPatient, Statement.RETURN_GENERATED_KEYS);
            ps2.setString(1, name);
            ps2.setInt(2, age);
            ps2.setInt(3, bedId);

            ps2.executeUpdate();

            ResultSet keys = ps2.getGeneratedKeys();
            keys.next();
            int patientId = keys.getInt(1);
            // 3. UPDATE BED
            String updateBed = "UPDATE Beds SET status = 'OCCUPIED' WHERE bed_id = ?";
            PreparedStatement ps3 = conn.prepareStatement(updateBed);
            ps3.setInt(1, bedId);

            if (ps3.executeUpdate() == 0) {
                throw new Exception("Update giường thất bại!");
            }
            // 4. INSERT FINANCE
            String insertFinance = "INSERT INTO Finance(patient_id, amount) VALUES (?, ?)";
            PreparedStatement ps4 = conn.prepareStatement(insertFinance);
            ps4.setInt(1, patientId);
            ps4.setDouble(2, money);

            if (ps4.executeUpdate() == 0) {
                throw new Exception("Lưu tiền thất bại!");
            }
            // COMMIT
            conn.commit();
            System.out.println("Tiếp nhận thành công!");

        } catch (Exception e) {

            //ROLLBACK
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println("Lỗi: " + e.getMessage());

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
