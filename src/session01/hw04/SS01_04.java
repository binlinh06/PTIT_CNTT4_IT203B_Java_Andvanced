package session01.hw04;

import java.io.IOException;

public class SS01_04 {

    // Method C
    public static void saveToFile() throws IOException {
        System.out.println("Đang lưu dữ liệu vào file...");

        // giả lập lỗi ghi file
        throw new IOException("Lỗi khi ghi file!");
    }

    // Method B
    public static void processUserData() throws IOException {
        System.out.println("Đang xử lý dữ liệu người dùng...");
        saveToFile(); // gọi Method C
    }

    // Method A (main)
    public static void main(String[] args) {

        try {
            processUserData(); // gọi Method B
        }
        catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}