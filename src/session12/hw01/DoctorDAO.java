package session12.hw01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * PreparedStatement là "tấm khiên" chống SQL Injection vì:
 *
 * - Câu lệnh SQL được biên dịch trước (pre-compiled) bởi database.
 * - Các dấu ? chỉ là vị trí tham số, KHÔNG phải là một phần của câu lệnh SQL.
 *
 * Khi truyền dữ liệu vào:
 * - Dữ liệu được coi là giá trị thuần (data), không được thực thi như SQL.
 *
 * Ví dụ:
 *   input: ' OR '1'='1
 *
 * Với Statement:
 *   → bị nối vào SQL → gây injection
 *
 * Với PreparedStatement:
 *   → được coi là chuỗi bình thường → không phá vỡ câu lệnh
 *
 * Kết luận:
 * → PreparedStatement tách biệt "câu lệnh" và "dữ liệu"
 * → Ngăn chặn SQL Injection hoàn toàn
 */
public class DoctorDAO {

    public boolean login(String code, String password) {

        String sql = "SELECT * FROM Doctors_Login WHERE doctor_code = ? AND password = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setString(1, code);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // có dữ liệu → login thành công

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
