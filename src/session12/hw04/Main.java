package session12.hw04;

public class Main {
    public static void main(String[] args) {

        LabDAO dao = new LabDAO();

        long start = System.currentTimeMillis();

        dao.insertBulk();

        long end = System.currentTimeMillis();

        System.out.println("Thời gian: " + (end - start) + " ms");
    }
}