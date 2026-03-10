package session03.hw04;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

record User(String username, String email, String status) {}

public class Main {
     public void main(String[] args) {
        List<User> users = List.of(
                new User("alice", "alice@gmail.com", "ACTIVE"),
                new User("bob", "bob@yahoo.com", "INACTIVE"),
                new User("alice", "alice2@gmail.com", "ACTIVE"),
                new User("charlie", "charlie@gmail.com", "ACTIVE")
        );
        Collection<User> uniqueUsers = users.stream()
                .collect(Collectors.toMap(
                        User::username,
                        user->user,
                        (u1,u2) -> u1
                ))
                .values();
        uniqueUsers.forEach(System.out::println);
    }
}
