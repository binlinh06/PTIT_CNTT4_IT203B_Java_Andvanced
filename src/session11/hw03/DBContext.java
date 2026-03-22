package session11.hw03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    // 1. Hằng số cấu hình
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Hospital_DB03";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Linh110711@";

    // 2. Lấy connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}
