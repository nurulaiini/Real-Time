package org.example;

public class TestSleep extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("ONE");
            sleep(200);
            System.out.println("TWO");
            sleep(200);
            System.out.println("THREE");
            sleep(200);
            System.out.println("xxxxxxxxxx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 1; i < 20; i++) {
            Thread t = new TestSleep();
            t.start();
            try {
                t.join();  // Wait for this thread to finish before starting the next
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}