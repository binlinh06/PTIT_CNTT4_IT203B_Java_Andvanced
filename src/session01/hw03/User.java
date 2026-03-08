package session01.hw03;

public class User {

    private int age;

    public void setAge(int age) {
        // kiểm tra dữ liệu
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không thể âm!");
        }

        // nếu hợp lệ thì gán giá trị
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
