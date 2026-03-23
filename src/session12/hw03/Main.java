package session12.hw03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SurgeryDAO dao = new SurgeryDAO();

        System.out.print("Nhập surgery_id: ");
        int id = Integer.parseInt(sc.nextLine());

        dao.getSurgeryFee(id);
    }
}