package session11.hw01;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DBContext.getConnection();

            if (conn != null) {
                System.out.println("Kết nối thành công!");
            }

            conn.close(); // nhớ đóng

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
