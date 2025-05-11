package Multithreading;

public class MyThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Thread is running...");
            try {
                Thread.sleep(500); // Sleep for 0.5 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread has been stopped.");
    }

    public void shutdown() {
        running = false;
    }
}

