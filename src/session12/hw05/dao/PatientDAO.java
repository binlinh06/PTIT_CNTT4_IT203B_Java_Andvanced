package session12.hw05.dao;
import session12.hw05.config.DBContext;
import session12.hw05.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {

    // 1. Danh sách bệnh nhân
    public List<Patient> getAll() {
        List<Patient> list = new ArrayList<>();
        String sql = "SELECT * FROM Inpatients";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                list.add(new Patient(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("department"),
                        rs.getString("disease"),
                        rs.getInt("admission_days")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // 2. Thêm bệnh nhân (chống SQL Injection)
    public void add(Patient p) {
        String sql = "INSERT INTO Inpatients(name, age, department, disease, admission_days) VALUES (?, ?, ?, ?, ?)";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, p.getName()); // xử lý được L'Oréal
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDepartment());
            ps.setString(4, p.getDisease());
            ps.setInt(5, p.getDays());

            ps.executeUpdate();
            System.out.println("Thêm thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. Cập nhật bệnh án
    public void updateDisease(int id, String disease) {
        String sql = "UPDATE Inpatients SET disease = ? WHERE id = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, disease);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Cập nhật thành công!");
            else
                System.out.println("Không tìm thấy bệnh nhân!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. Xuất viện + tính phí (CALL PROCEDURE)
    public void discharge(int id) {
        String sql = "{CALL CALCULATE_DISCHARGE_FEE(?, ?)}";

        try (
                Connection conn = DBContext.getConnection();
                CallableStatement cs = conn.prepareCall(sql);
        ) {

            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.DECIMAL);

            cs.execute();

            double fee = cs.getDouble(2);

            if (fee > 0)
                System.out.println("Viện phí: " + fee);
            else
                System.out.println("Không tìm thấy bệnh nhân!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
