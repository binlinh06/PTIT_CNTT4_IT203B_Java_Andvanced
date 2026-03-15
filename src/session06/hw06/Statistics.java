package session06.hw06;

import java.util.*;

public class Statistics {

    public static void printStats(List<Room> rooms) {

        System.out.println("\n=== THỐNG KÊ ===");

        int totalSold = 0;

        for (Room r : rooms) {

            System.out.println("Phòng " + r.getName() +
                    ": Đã bán "
                    + r.getSoldCount()
                    + "/" + r.getCapacity());

            totalSold += r.getSoldCount();
        }

        int revenue = totalSold * 150000;

        System.out.println("Tổng doanh thu: "
                + revenue + " VNĐ");
    }
}
