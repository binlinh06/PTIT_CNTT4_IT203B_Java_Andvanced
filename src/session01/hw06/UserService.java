package session01.hw06;

import java.io.IOException;

public class UserService {

    public static void processUser(User user) throws IOException {

        // Defensive programming (tránh NullPointerException)
        if (user != null && user.getName() != null) {
            System.out.println("Xin chào: " + user.getName());
        } else {
            System.out.println("Tên người dùng không hợp lệ");
        }

        saveToFile();
    }

    public static void saveToFile() throws IOException {

        System.out.println("Đang lưu dữ liệu vào file...");

        // giả lập lỗi file
        throw new IOException("Không thể ghi file!");
    }

}
