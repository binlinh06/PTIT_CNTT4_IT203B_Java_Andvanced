package session13.hw04;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        DashboardDAO dao = new DashboardDAO();

        List<BenhNhanDTO> list = dao.getDashboard();

        for (BenhNhanDTO bn : list) {
            System.out.println("Bệnh nhân: " + bn.name);

            for (DichVu dv : bn.dsDichVu) {
                System.out.println("   - " + dv.name);
            }
        }
    }
}
