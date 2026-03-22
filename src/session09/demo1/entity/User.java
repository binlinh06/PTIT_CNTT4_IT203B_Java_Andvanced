package session09.demo1.entity;

import java.util.Scanner;

public class User {
    private String userId;
    private String userName;
    private int age;
    private String role;
    private double score;

    // Constructor rỗng
    public User() {
    }

    // Constructor đầy đủ
    public User(String userId, String userName, int age, String role, double score) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.role = role;
        this.score = score;
    }

    // Getter/Setter
    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public double getScore() {
        return score;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setScore(double score) {
        this.score = score;
    }

    // Nhập dữ liệu
    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã người dùng: ");
        this.userId = scanner.nextLine();

        do {
            System.out.print("Nhập tên: ");
            this.userName = scanner.nextLine();
        } while (this.userName.trim().isEmpty());

        do {
            System.out.print("Nhập tuổi (>=18): ");
            this.age = Integer.parseInt(scanner.nextLine());
        } while (this.age < 18);

        do {
            System.out.print("Nhập role (USER/ADMIN): ");
            this.role = scanner.nextLine().toUpperCase();
        } while (!this.role.equals("USER") && !this.role.equals("ADMIN"));

        do {
            System.out.print("Nhập score (0-10): ");
            this.score = Double.parseDouble(scanner.nextLine());
        } while (this.score < 0 || this.score > 10);
    }

    // Hiển thị
    public void displayData() {
        System.out.printf("| %-5s | %-15s | %-3d | %-6s | %-5.2f |\n",
                userId, userName, age, role, score);
    }
}
//Phòng Công nghệ Thông tin của một công ty đang gặp khó khăn trong việc quản lý danh sách người dùng nội bộ bằng các file Excel rời rạc. Việc tra cứu thông tin người dùng, lọc những người dùng có quyền quản trị hệ thống, hay kiểm soát việc nhập trùng lặp mã người dùng mất rất nhiều thời gian và dễ xảy ra sai sót.
//Hãy viết chương trình Java thực hiện các yêu cầu kiến trúc sau:
//
//1. Xây dựng các lớp sau (Package ra.entity)
//Xây dựng lớp User gồm:
//Các thuộc tính
//userId (String – Mã người dùng – không được trùng lặp, VD: U001, U002,...)
//userName (String – Tên người dùng)
//age (int – Tuổi – Phải từ 18 tuổi trở lên)
//role (String – Vai trò: USER / ADMIN)
//score (double – Điểm đánh giá hiệu suất – thang điểm 10)
//
//Các yêu cầu
//Gồm 2 constructor
//Không tham số
//Đầy đủ tham số
//Các phương thức getter/setter
//Phương thức
//inputData(Scanner scanner)
//
//Cho phép nhập đầy đủ thông tin của người dùng từ bàn phím và validate dữ liệu nhập. Nếu nhập sai yêu cầu phải nhập lại.
//
//Phương thức
//displayData()
//
//Hiển thị thông tin người dùng ra màn hình với định dạng rõ ràng.
//
//2. Xây dựng lớp nghiệp vụ sau (Package ra.business)
//Tạo lớp:
//UserBusiness
//
//Quản lý một danh sách:
//List<User>
//
//Xây dựng các phương thức xử lý logic dưới đây.
//BẮT BUỘC sử dụng Java 8 (Stream API, Lambda, Optional) cho các thao tác.
//
//Các chức năng
//1. Hiển thị danh sách
//Hiển thị danh sách người dùng theo định dạng bảng.
//Nếu danh sách rỗng thì in ra thông báo lỗi.
//
//2. Thêm người dùng
//Nếu trùng userId thì in ra lỗi:
//Mã người dùng đã tồn tại
//
//
//3. Cập nhật thông tin người dùng
//Cho người dùng lựa chọn thông tin muốn cập nhật.
//Không cho phép sửa mã người dùng.
//
//4. Tìm kiếm theo tên
//Tìm kiếm tương đối
//Không phân biệt hoa thường
//Hiển thị:
//thông tin chi tiết người dùng tìm được
//tổng số kết quả
//Nếu không tìm thấy thì in ra lỗi.
//
//5. Xóa người dùng
//Nếu sau khi thực hiện xóa mà kích thước danh sách không thay đổi, in ra lỗi:
//Mã người dùng không tồn tại trong hệ thống
//
//
//6. Lọc danh sách người dùng ADMIN
//Lọc những người dùng có:
//role = ADMIN
//
//
//7. Sắp xếp danh sách
//Sắp xếp người dùng theo:
//score giảm dần
//
//Hiển thị danh sách sau khi sắp xếp.
//
//3. Xây dựng lớp Giao diện (Package ra.presentation)
//Xây dựng lớp UserManagement chứa main().
//Hiển thị menu sau:
//********************* QUẢN LÝ NGƯỜI DÙNG *********************
//
//1. Hiển thị danh sách toàn bộ người dùng
//2. Thêm mới người dùng
//3. Cập nhật thông tin người dùng theo mã
//4. Xóa người dùng theo mã
//5. Tìm kiếm người dùng theo tên
//6. Lọc danh sách người dùng ADMIN
//7. Sắp xếp danh sách theo điểm đánh giá giảm dần
//8. Thoát
//
//Lựa chọn của bạn:
//
//
//4. Quy tắc nghiệp vụ trên giao diện
//Chức năng 2 – Thêm người dùng
//Cho phép người dùng thêm liên tục nhiều người dùng
//Nếu trùng mã phải in:
//Mã người dùng đã tồn tại
//
//Không làm chương trình dừng đột ngột.
//
//Chức năng 3 & 4
//Nếu không tìm thấy người dùng thì in ra:
//Mã người dùng không tồn tại trong hệ thống
//
//
//Chức năng 3 – Cập nhật
//Cho phép người dùng chọn thông tin cần cập nhật.
//Không cho phép sửa mã người dùng.
//
//5. Yêu cầu kỹ thuật
//Các chức năng:
//tìm kiếm
//sắp xếp
//lọc
//bắt buộc sử dụng
//Stream API
//Lambda Expression
//Optional (nếu cần)
//
//
//6. Điểm cộng (Bonus)
//Sinh viên sử dụng Design Pattern trong chương trình sẽ được cộng điểm.
//Ví dụ:
//Singleton Pattern
//Áp dụng cho lớp UserBusiness để đảm bảo chỉ có một đối tượng quản lý danh sách người dùng.
//Hoặc
//Strategy Pattern
//Áp dụng cho chức năng sắp xếp danh sách người dùng.