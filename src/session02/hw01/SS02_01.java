package session02.hw01;

public class SS02_01 {
}
//Lựa chọn Functional Interface phù hợp
//
//Trong hệ thống quản lý User, mỗi công việc sẽ tương ứng với một Functional Interface khác nhau trong Java.
//
//1. Kiểm tra xem một User có phải là Admin hay không (trả về true/false)
//
//Functional Interface: Predicate<User>
//
//Giải thích:
//
//Predicate<T> dùng để kiểm tra điều kiện và trả về boolean.
//
//Trong trường hợp này ta chỉ cần kiểm tra User có phải admin hay không.
//
//Ví dụ:
//
//Predicate<User> isAdmin = user -> user.getRole().equals("ADMIN");
//2. Chuyển đổi một đối tượng User thành một chuỗi String chứa thông tin username
//
//Functional Interface: Function<User, String>
//
//Giải thích:
//
//Function<T, R> dùng để biến đổi dữ liệu từ kiểu T sang kiểu R.
//
//Ở đây ta chuyển từ User → String.
//
//Ví dụ:
//
//Function<User, String> getUsername = user -> user.getUsername();
//3. In thông tin chi tiết của User ra màn hình Console
//
//Functional Interface: Consumer<User>
//
//Giải thích:
//
//Consumer<T> dùng để thực hiện một hành động với dữ liệu nhưng không trả về giá trị.
//
//Việc in ra console chỉ là hành động.
//
//Ví dụ:
//
//Consumer<User> printUser = user -> System.out.println(user);
//4. Khởi tạo một đối tượng User mới với các giá trị mặc định
//
//Functional Interface: Supplier<User>
//
//Giải thích:
//
//Supplier<T> dùng để tạo và cung cấp một đối tượng mà không cần tham số đầu vào.
//
//Ví dụ:
//
//Supplier<User> createUser = () -> new User("defaultUser", "USER");