package session06.hw06;

import java.util.*;
import java.util.concurrent.*;

public class Main {

    static ExecutorService executor;
    static List<Room> rooms = new ArrayList<>();
    static List<BookingCounter> counters = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng");
            System.out.println("3. Tiếp tục");
            System.out.println("4. Thêm vé");
            System.out.println("5. Thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Số phòng: ");
                    int roomCount = sc.nextInt();

                    System.out.print("Vé/phòng: ");
                    int ticketCount = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counterCount = sc.nextInt();

                    rooms.clear();

                    for (int i = 0; i < roomCount; i++) {

                        char name = (char) ('A' + i);
                        rooms.add(new Room("" + name, ticketCount));
                    }

                    executor = Executors.newFixedThreadPool(counterCount + 2);

                    for (int i = 1; i <= counterCount; i++) {

                        BookingCounter c =
                                new BookingCounter("Quầy " + i, rooms);

                        counters.add(c);
                        executor.submit(c);
                    }

                    executor.submit(new TicketSupplier(rooms));

                    System.out.println("Hệ thống đã khởi động.");

                    break;

                case 4:

                    System.out.print("Chọn phòng: ");
                    String roomName = sc.next();

                    for (Room r : rooms) {

                        if (r.getName().equals(roomName)) {

                            r.addTickets(5);
                            System.out.println("Đã thêm vé.");
                        }
                    }

                    break;

                case 5:

                    Statistics.printStats(rooms);
                    break;

                case 6:

                    new DeadlockDetector().run();
                    break;

                case 7:

                    if (executor != null)
                        executor.shutdownNow();

                    System.out.println("Đang dừng hệ thống...");
                    return;
            }
        }
    }
}