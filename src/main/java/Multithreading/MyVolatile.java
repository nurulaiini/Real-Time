package Multithreading;

public class MyVolatile {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();

        System.out.println("Press ENTER to stop the thread...");

        try {

            System.in.read(); // Wait for user to press ENTER
        } catch (Exception e) {
            e.printStackTrace();
        }

        t.shutdown(); // Call shutdown to stop the thread
    }
}



