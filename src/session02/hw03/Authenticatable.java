package session02.hw03;

@FunctionalInterface
public interface Authenticatable {

    // 1. Phương thức trừu tượng
    String getPassword();

    // 2. Default method kiểm tra xác thực
    default boolean isAuthenticated() {
        String password = getPassword();
        return password != null && !password.isEmpty();
    }

    // 3. Static method mô phỏng mã hóa mật khẩu
    static String encrypt(String rawPassword) {
        return "ENC_" + rawPassword;
    }
}