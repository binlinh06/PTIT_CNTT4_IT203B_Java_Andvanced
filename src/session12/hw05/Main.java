package session12.hw05;

import session12.hw05.model.Patient;
import session12.hw05.service.PatientService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();

        while (true) {
            System.out.println("\n===== RHMS =====");
            System.out.println("1. Danh sách bệnh nhân");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("3. Cập nhật bệnh án");
            System.out.println("4. Xuất viện & tính phí");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    service.showAll();
                    break;

                case 2:
                    try {
                        System.out.print("Tên: ");
                        String name = sc.nextLine();

                        System.out.print("Tuổi: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Khoa: ");
                        String dep = sc.nextLine();

                        System.out.print("Bệnh: ");
                        String dis = sc.nextLine();

                        System.out.print("Số ngày: ");
                        int days = Integer.parseInt(sc.nextLine());

                        service.add(new Patient(0, name, age, dep, dis, days));
                    } catch (Exception e) {
                        System.out.println("Dữ liệu sai!");
                    }
                    break;

                case 3:
                    System.out.print("ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Bệnh mới: ");
                    String dis = sc.nextLine();

                    service.update(id, dis);
                    break;

                case 4:
                    System.out.print("ID: ");
                    int did = Integer.parseInt(sc.nextLine());
                    service.discharge(did);
                    break;

                case 5:
                    return;
            }
        }
    }
}
