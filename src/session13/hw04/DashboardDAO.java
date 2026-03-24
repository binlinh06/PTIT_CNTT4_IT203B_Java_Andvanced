package session13.hw04;

import java.sql.*;
import java.util.*;

public class DashboardDAO {

    public List<BenhNhanDTO> getDashboard() throws Exception {

        Connection conn = DBContext.getConnection();

        String sql = """
            SELECT bn.id AS bn_id, bn.name AS bn_name,
                   dv.id AS dv_id, dv.name AS dv_name
            FROM BenhNhan bn
            LEFT JOIN DichVuSuDung dv 
            ON bn.id = dv.maBenhNhan
        """;

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        // Map để gom dữ liệu
        Map<Integer, BenhNhanDTO> map = new LinkedHashMap<>();

        while (rs.next()) {

            int bnId = rs.getInt("bn_id");

            // Nếu chưa có → tạo mới
            if (!map.containsKey(bnId)) {
                BenhNhanDTO bn = new BenhNhanDTO();
                bn.id = bnId;
                bn.name = rs.getString("bn_name");

                map.put(bnId, bn);
            }

            BenhNhanDTO bn = map.get(bnId);
            // BẪY 2: BỆNH NHÂN KHÔNG CÓ DỊCH VỤ
            int dvId = rs.getInt("dv_id");

            // Nếu dv_id NULL → getInt trả về 0
            if (!rs.wasNull()) {
                String dvName = rs.getString("dv_name");

                bn.dsDichVu.add(new DichVu(dvId, dvName));
            }

            /*
             * ✔ Nếu NULL:
             * - KHÔNG add dịch vụ
             * - dsDichVu vẫn là []
             * => KHÔNG bị mất bệnh nhân
             */
        }

        conn.close();

        return new ArrayList<>(map.values());
    }
}
