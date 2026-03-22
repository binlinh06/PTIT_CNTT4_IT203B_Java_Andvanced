package session11.hw05.dao;

import session11.hw05.config.DBContext;
import session11.hw05.model.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // 1. Lấy danh sách bác sĩ
    public List<Doctor> getAllDoctors() {
        List<Doctor> list = new ArrayList<>();
        String sql = "SELECT * FROM Doctors";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                list.add(new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("full_name"),
                        rs.getString("specialty")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. Thêm bác sĩ
    public boolean addDoctor(Doctor d) {
        String sql = "INSERT INTO Doctors VALUES (?, ?, ?)";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, d.getId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getSpecialty());

            return ps.executeUpdate() > 0;

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("❌ Mã bác sĩ bị trùng!");
        } catch (SQLException e) {
            System.out.println("❌ Lỗi dữ liệu (có thể quá dài)!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    // 3. Thống kê chuyên khoa
    public void countBySpecialty() {
        String sql = "SELECT specialty, COUNT(*) AS total FROM Doctors GROUP BY specialty";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                System.out.println(rs.getString("specialty") + ": " + rs.getInt("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}