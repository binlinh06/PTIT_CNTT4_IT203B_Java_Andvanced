package session01.hw06;

import java.io.IOException;
import java.util.Scanner;

public class SS01_06 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Nhập tên: ");
            String name = sc.nextLine();

            User user = new User(name);

            System.out.print("Nhập năm sinh: ");
            String input = sc.nextLine();

            int year = Integer.parseInt(input);
            int age = 2026 - year;

            user.setAge(age);

            UserService.processUser(user);

        }
        catch (NumberFormatException e) {
            Logger.logError("Năm sinh phải là số!");
        }
        catch (InvalidAgeException e) {
            Logger.logError(e.getMessage());
        }
        catch (IOException e) {
            Logger.logError("Lỗi ghi file: " + e.getMessage());
        }
        finally {
            sc.close();
            System.out.println("Dọn dẹp tài nguyên...");
        }

        System.out.println("Chương trình kết thúc an toàn.");
    }
}
