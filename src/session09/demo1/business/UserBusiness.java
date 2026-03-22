package session09.demo1.business;

import session09.demo1.entity.User;

import java.util.*;
import java.util.stream.Collectors;

public class UserBusiness {
    private List<User> users;

    // Singleton
    private static UserBusiness instance;

    private UserBusiness() {
        users = new ArrayList<>();
    }

    public static UserBusiness getInstance() {
        if (instance == null) {
            instance = new UserBusiness();
        }
        return instance;
    }

    // 1. Hiển thị
    public void displayList() {
        if (users.isEmpty()) {
            System.out.println("Danh sách rỗng!");
            return;
        }
        users.forEach(User::displayData);
    }

    // 2. Thêm
    public void addUser(User user) {
        boolean exists = users.stream()
                .anyMatch(u -> u.getUserId().equals(user.getUserId()));

        if (exists) {
            System.out.println("Mã người dùng đã tồn tại");
        } else {
            users.add(user);
        }
    }

    // 3. Tìm theo ID (Optional)
    public Optional<User> findById(String id) {
        return users.stream()
                .filter(u -> u.getUserId().equals(id))
                .findFirst();
    }

    // 3. Update
    public void updateUser(String id, Scanner scanner) {
        Optional<User> optionalUser = findById(id);

        if (!optionalUser.isPresent()) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
            return;
        }

        User user = optionalUser.get();

        System.out.println("1. Tên");
        System.out.println("2. Tuổi");
        System.out.println("3. Role");
        System.out.println("4. Score");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Nhập tên mới: ");
                user.setUserName(scanner.nextLine());
                break;
            case 2:
                System.out.print("Nhập tuổi mới: ");
                user.setAge(Integer.parseInt(scanner.nextLine()));
                break;
            case 3:
                System.out.print("Nhập role: ");
                user.setRole(scanner.nextLine());
                break;
            case 4:
                System.out.print("Nhập score: ");
                user.setScore(Double.parseDouble(scanner.nextLine()));
                break;
        }
    }

    // 4. Tìm theo tên
    public void searchByName(String name) {
        List<User> result = users.stream()
                .filter(u -> u.getUserName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Không tìm thấy!");
        } else {
            result.forEach(User::displayData);
            System.out.println("Tổng: " + result.size());
        }
    }

    // 5. Xóa
    public void deleteUser(String id) {
        int sizeBefore = users.size();

        users.removeIf(u -> u.getUserId().equals(id));

        if (sizeBefore == users.size()) {
            System.out.println("Mã người dùng không tồn tại trong hệ thống");
        }
    }

    // 6. Lọc ADMIN
    public void filterAdmin() {
        List<User> admins = users.stream()
                .filter(u -> u.getRole().equals("ADMIN"))
                .collect(Collectors.toList());

        admins.forEach(User::displayData);
    }

    // 7. Sắp xếp
    public void sortByScoreDesc() {
        users = users.stream()
                .sorted((u1, u2) -> Double.compare(u2.getScore(), u1.getScore()))
                .collect(Collectors.toList());

        displayList();
    }
}
