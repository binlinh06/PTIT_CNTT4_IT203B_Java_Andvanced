package session03.hw03;

public class Main {
    static void main(String[] args) {
        UserRepository repo = new UserRepository();
        var userOpt = repo.findUserByUsername("alice");
        userOpt.ifPresent(user ->
                System.out.println("Welcome " + user.username())
        );

        System.out.println(userOpt.orElse(null) == null ? "Guest login" : "");
    }
}
