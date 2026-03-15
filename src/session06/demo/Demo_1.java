package session06.demo;

import java.util.Random;

public class Demo_1 extends Thread {
    String[] names ={
            "An", "Bình", "Chi", "Dũng", "Hà",
            "Huy", "Lan", "Minh", "Nam", "Trang"
    };
    Random random = new Random();

    @Override
    public void run() {
        while (true) {
            int index = random.nextInt(names.length);
            System.out.println("Bạn được gọi: " + names[index]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Demo_1 demo = new Demo_1();
        demo.start();
    }
}
