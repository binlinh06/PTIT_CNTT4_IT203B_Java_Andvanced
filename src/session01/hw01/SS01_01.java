package session01.hw01;

import java.util.Scanner;

public class SS01_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Nhập năm sinh của bạn: ");
            String input = sc.nextLine();

            int namSinh = Integer.parseInt(input); // chuyển String → int
            int tuoi = 2026 - namSinh;

            System.out.println("Tuổi của bạn là: " + tuoi);
        }
        catch (NumberFormatException e) {
            System.out.println("Lỗi: Bạn phải nhập số cho năm sinh! Ví dụ: 2006");
        }
        finally {
            sc.close(); // đóng Scanner
            System.out.println("Thực hiện dọn dẹp tài nguyên trong finally...");
        }
    }
}
