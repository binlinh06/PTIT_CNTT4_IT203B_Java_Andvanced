package session12.hw02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Nhập nhiệt độ: ");
            double temp = Double.parseDouble(sc.nextLine());

            System.out.print("Nhập nhịp tim: ");
            int hr = Integer.parseInt(sc.nextLine());

            dao.updateVitals(id, temp, hr);

        } catch (Exception e) {
            System.out.println(" Dữ liệu nhập sai!");
        }
    }
}
