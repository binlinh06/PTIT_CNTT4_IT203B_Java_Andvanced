package session02.hw04;

import java.util.*;
import java.util.function.*;

class User {
    private String username;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}

public class Main {
    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User("linh"),
                new User("ngoc"),
                new User("java")
        );

        users.stream()
                .map(User::getUsername)
                .forEach(System.out::println);

        Supplier<User> supplier = User::new;
        User newUser = supplier.get();
    }
}
