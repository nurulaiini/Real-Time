package Week_07;

import java.util.Random;

public class Deadlock implements Runnable {
    private static final Object resource1 = new Object();
    private static final Object resource2 = new Object();
    private final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Deadlock(), "Thread-1");
        Thread thread2 = new Thread(new Deadlock(), "Thread-2");

        // Start worker threads
        thread1.start();
        thread2.start();

        // Start monitoring thread
        Thread monitor = new Thread(new Runnable(){
            public void run() {
                while (true) {
                    System.out.println("[Monitor] " + thread1.getName() + " state: " + thread1.getState());
                    System.out.println("[Monitor] " + thread2.getName() + " state: " + thread2.getState());

                    if (thread1.getState() == Thread.State.BLOCKED && thread2.getState() == Thread.State.BLOCKED) {
                        System.out.println("[Monitor] Potential deadlock detected! Exiting...");
                        System.exit(1);
                    }

                    try {
                        Thread.sleep(1000); // monitor every second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        monitor.setDaemon(true); // Ensure the monitor doesn't prevent shutdown
        monitor.start();
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 1...");
            synchronized (resource1) {
                System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 1.");

                try {
                    Thread.sleep(50); // simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("[" + Thread.currentThread().getName() + "] Trying to lock resource 2...");
                synchronized (resource2) {
                    System.out.println("[" + Thread.currentThread().getName() + "] Locked resource 2.");
                }
            }

            try {
                Thread.sleep(random.nextInt(100)); // sleep randomly to increase concurrency
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
