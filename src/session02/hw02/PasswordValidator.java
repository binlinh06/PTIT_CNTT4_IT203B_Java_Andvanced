package session02.hw02;

@FunctionalInterface
public interface PasswordValidator {
    boolean isValid(String password);
}