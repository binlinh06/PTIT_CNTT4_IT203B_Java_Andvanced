package session11.hw01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//P1
/*
 * Vấn đề:
 * - Mỗi lần truy vấn đều tạo Connection mới nhưng không đóng.
 *
 * Hậu quả:
 * - Gây rò rỉ kết nối (connection leak)
 * - Sau thời gian dài, database bị đầy connection → hệ thống treo
 * - Xuất hiện lỗi "Communications link failure"
 *
 * Nguy hiểm:
 * - Hệ thống bệnh viện cần chạy 24/7 → treo hệ thống sẽ ảnh hưởng đến bệnh nhân
 *
 * Kết luận:
 * - Cần quản lý connection tập trung
 * - Luôn đóng connection sau khi sử dụng
 */
public class PatientDAO {

    public void getPatients() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();

            String sql = "SELECT * FROM patients";
            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3. Đóng theo thứ tự ngược
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
