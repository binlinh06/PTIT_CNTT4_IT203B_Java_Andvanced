package session12.hw04;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 * Vấn đề:
 * - Dùng Statement trong vòng lặp 1000 lần
 *
 * Mỗi lần chạy:
 * - Database phải:
 *   1. Parse câu lệnh SQL
 *   2. Tạo Execution Plan
 *   3. Thực thi
 *
 * → Lặp lại 1000 lần cho cùng 1 cấu trúc SQL → rất lãng phí tài nguyên
 *
 * Hậu quả:
 * - Tốn CPU DB Server
 * - Chậm hệ thống (đặc biệt giờ cao điểm)
 *
 * Giải pháp:
 * - Dùng PreparedStatement
 * - SQL được biên dịch 1 lần (pre-compiled)
 * - Tái sử dụng Execution Plan
 *
 * Kết luận:
 * → Tăng tốc độ đáng kể khi insert/update nhiều lần
 */
public class LabDAO {

    public void insertBulk() {

        String sql = "INSERT INTO Lab_Results(patient_id, result_value) VALUES (?, ?)";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            for (int i = 1; i <= 1000; i++) {

                ps.setInt(1, i);
                ps.setDouble(2, Math.random() * 100);

                ps.executeUpdate(); // dùng lại plan
            }

            System.out.println("Insert thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}