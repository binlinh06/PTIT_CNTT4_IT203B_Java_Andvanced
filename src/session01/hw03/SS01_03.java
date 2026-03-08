package session01.hw03;

public class SS01_03 {
    public static void main(String[] args) {

        User u = new User();

        try {
            u.setAge(-5); // thử nhập tuổi âm
            System.out.println("Tuổi: " + u.getAge());
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Chương trình vẫn tiếp tục chạy...");
    }
}
