package session01.hw06;

public class InvalidAgeException extends Exception {

    public InvalidAgeException(String msg) {
        super(msg); // truyền thông báo lỗi lên lớp cha
    }

}
