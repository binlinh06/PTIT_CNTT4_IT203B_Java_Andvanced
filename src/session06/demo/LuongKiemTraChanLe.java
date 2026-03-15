package session06.demo;

import java.util.Random;

public class LuongKiemTraChanLe extends Thread {
    private DataShare dataShare;

    public LuongKiemTraChanLe(DataShare dataShare) {
        this.dataShare = dataShare;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            synchronized (dataShare) {
                if (dataShare.getNumber() == 1) {

                    int n = dataShare.getNumber();
                    if (n % 2 == 0) {
                        System.out.println("Thread 2-Chan le" +dataShare.getNumber());
                    }else {

                    }
                    dataShare.setControl(1);
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
}
