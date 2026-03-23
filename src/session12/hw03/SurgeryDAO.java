package session12.hw03;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.Types;
/*
 * JDBC bắt buộc phải gọi registerOutParameter() vì:
 *
 * - Driver cần biết trước kiểu dữ liệu của tham số OUT
 * - Để cấp phát bộ nhớ và xử lý đúng kiểu khi nhận kết quả từ DB
 *
 * Nếu không gọi:
 * → JDBC không biết kiểu → lỗi "column index is out of range"
 * → hoặc không lấy được dữ liệu
 *
 * Với kiểu DECIMAL trong SQL:
 * → dùng: Types.DECIMAL trong Java
 *
 * Kết luận:
 * - Phải registerOutParameter() trước khi execute
 * - Và dùng đúng kiểu dữ liệu tương ứng
 */
public class SurgeryDAO {

    public void getSurgeryFee(int surgeryId) {

        String sql = "{CALL GET_SURGERY_FEE(?, ?)}";

        try (
                Connection conn = DBContext.getConnection();
                CallableStatement cs = conn.prepareCall(sql);
        ) {

            // IN parameter
            cs.setInt(1, surgeryId);

            cs.registerOutParameter(2, Types.DECIMAL);

            // thực thi
            cs.execute();

            // lấy kết quả
            double cost = cs.getDouble(2);

            if (cost > 0) {
                System.out.println("Chi phí phẫu thuật: " + cost);
            } else {
                System.out.println("Không tìm thấy loại phẫu thuật!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
