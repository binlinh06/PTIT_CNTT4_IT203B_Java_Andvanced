package session01.hw05;

public class SS01_05 {
    public static void main(String[] args) {

        User user = new User();

        try {
            user.setAge(-3); // thử nhập tuổi âm
            System.out.println("Tuổi: " + user.getAge());
        }
        catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
