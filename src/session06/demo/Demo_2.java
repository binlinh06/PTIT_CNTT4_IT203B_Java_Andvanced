package session06.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Demo_2 extends Thread{
    private List<String> listName;
    private List<String> listAddress;

    public Demo_2() {
        listName = Arrays.asList("Linh","Huy","Minh","Ha","Long","My","Mo","Binh","Tien","Mia");
        listAddress = Arrays.asList("HN","HCM","Da Nang","Hue","Tuyen Quang","Thai Binh","Thanh Hoa","Quang Ninh","Ca Mau");
    }

    @Override
    public void run(){
        Random rand = new Random();
        while(true){
            int index = rand.nextInt(listName.size());
            System.out.println("Chao ban"+listName.get(index) +"Den tu" + listAddress.get(index));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        Demo_2 demo = new Demo_2();
        demo.start();
    }
}
