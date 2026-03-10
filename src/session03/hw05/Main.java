package session03.hw05;

import java.util.Comparator;
import java.util.List;

record User(String username, String email, String status) {}

public class Main {
    public static void main(String[] args) {

        List<User> users = List.of(
                new User("alexander", "alex@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("charlotte", "charlotte@gmail.com", "ACTIVE"),
                new User("ben", "ben@gmail.com", "ACTIVE"),
                new User("Benjamin", "benjamin@gmail.com", "ACTIVE")
        );
        users.stream()
                .sorted(Comparator.comparingInt((User u)->u.username().length()).reversed())
                .limit(3)
                .forEach(user -> System.out.println(user.username()));
    }
}
