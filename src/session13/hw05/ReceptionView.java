package session13.hw05;

import java.util.Scanner;

public class ReceptionView {

    private PatientController controller = new PatientController();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem giường trống");
            System.out.println("2. Tiếp nhận bệnh nhân");
            System.out.println("3. Thoát");

            System.out.print("Chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    controller.showEmptyBeds();
                    break;
                case 2:
                    handleAddPatient();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }

    private void handleAddPatient() {
        try {
            System.out.print("Tên: ");
            String name = sc.nextLine();

            System.out.print("Tuổi: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Giường: ");
            int bedId = Integer.parseInt(sc.nextLine());

            System.out.print("Tiền tạm ứng: ");
            double money = Double.parseDouble(sc.nextLine());

            if (money <= 0) {
                System.out.println("Tiền phải > 0!");
                return;
            }

            controller.addPatient(name, age, bedId, money);

        } catch (Exception e) {
            System.out.println("Nhập sai định dạng!");
        }
    }
}