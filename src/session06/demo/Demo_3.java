package session06.demo;

import java.util.Random;

public class Demo_3 extends Thread {
    private DataShare dataShare;

    public Demo_3(DataShare dataShare) {
        this.dataShare = dataShare;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (dataShare) {
                if (dataShare.getNumber() == 1) {
                    int number = random.nextInt(100);
                    dataShare.setNumber(number);

                    System.out.println("Thread 1-Sinh so:" +dataShare.getNumber());
                    dataShare.setControl(2);
                    dataShare.notify();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    try {
                        dataShare.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public synchronized void start() {
        System.out.println("Phuong thuc duoc dong bo");
    }
    public static void main(String[] args) {
        DataShare dataShare = new DataShare();
        LuongKiemTraChanLe l = new LuongKiemTraChanLe(dataShare);
        Demo_3 demo = new Demo_3(dataShare);
        demo.start();
        l.start();
    }
}
