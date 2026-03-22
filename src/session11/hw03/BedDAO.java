package session11.hw03;

import java.sql.Connection;
import java.sql.PreparedStatement;
/*
 * executeUpdate() trả về số dòng (row) bị ảnh hưởng.
 *
 * - Nếu = 1 (hoặc >0):
 *      → Cập nhật thành công
 *
 * - Nếu = 0:
 *      → Không có dòng nào bị ảnh hưởng
 *      → Nghĩa là mã giường không tồn tại
 *
 * => Dựa vào giá trị này để thông báo chính xác cho người dùng
 */
public class BedDAO {

    public void updateBedStatus(int bedId) {

        String sql = "UPDATE Beds SET bed_status = 'Occupied' WHERE bed_id = ?";

        try (
                Connection conn = DBContext.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {

            ps.setInt(1, bedId);

            int rowsAffected = ps.executeUpdate(); // 🔥 quan trọng

            if (rowsAffected > 0) {
                System.out.println("Cập nhật giường thành công!");
            } else {
                System.out.println("Lỗi: Mã giường không tồn tại!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
