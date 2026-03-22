package session11.hw03;

public class Main {
    public static void main(String[] args) {

        BedDAO dao = new BedDAO();

        dao.updateBedStatus(1);     // có thể tồn tại
        dao.updateBedStatus(999);   // không tồn tại
    }
}
