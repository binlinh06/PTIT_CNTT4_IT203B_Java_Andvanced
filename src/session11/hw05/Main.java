package session11.hw05;

import session11.hw05.model.Doctor;
import session11.hw05.service.DoctorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoctorService service = new DoctorService();

        while (true) {
            System.out.println("\n===== RIKKEI CARE =====");
            System.out.println("1. Xem danh sách bác sĩ");
            System.out.println("2. Thêm bác sĩ");
            System.out.println("3. Thống kê chuyên khoa");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    service.showAll();
                    break;

                case 2:
                    try {
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Chuyên khoa: ");
                        String sp = sc.nextLine();

                        service.add(new Doctor(id, name, sp));
                    } catch (Exception e) {
                        System.out.println("❌ Dữ liệu không hợp lệ!");
                    }
                    break;

                case 3:
                    service.statistics();
                    break;

                case 4:
                    System.out.println("Thoát...");
                    return;

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}