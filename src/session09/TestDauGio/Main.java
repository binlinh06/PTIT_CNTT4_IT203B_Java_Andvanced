package session09.TestDauGio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = ProductDatabase.getInstance();
        int choice;
        do {
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Xem danh sách sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xoá sản phẩm");
            System.out.println("5. Thoát");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Chon loai (1.Physical, 2.Digital): ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    System.out.println("ID: ");
                    String id = sc.nextLine();

                    System.out.println("Name: ");
                    String name = sc.nextLine();

                    System.out.println("Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Extra (weight/size): ");
                    double extra = sc.nextDouble();

                    Product p = ProductFactory.createProduct(type, id, name, price, extra);
                    db.addProduct(p);
                    break;
                case 2:
                    db.getAll().forEach(Product::displayInfo);
                    break;
                case 3:
                    System.out.print("Nhap ID can update: ");
                    String uid = sc.nextLine();

                    System.out.print("Name moi: ");
                    String newName = sc.nextLine();

                    System.out.print("Price moi: ");
                    double newPrice = sc.nextDouble();

                    System.out.print("Extra moi: ");
                    double newExtra = sc.nextDouble();

                    Product newP = ProductFactory.createProduct(1, uid, newName, newPrice, newExtra);
                    db.updateProduct(uid, newP);
                    break;
                case 4:
                    System.out.print("Nhap ID can xoa: ");
                    String delete = sc.nextLine();
                    db.deleteProduct(delete);
                    break;
                case 5:
                    System.out.println("Thoát thành công!");
                    break;
                default:
                    System.out.println("ERROR");
            }
        } while (choice != 5);
    }
}
