package Week_07;

public class CompareExecutionTimes {
    public static void main(String[] args) {
        final int THREAD_COUNT = 10;

        Thread[] normal = new Thread[THREAD_COUNT];
        long startTime = System.nanoTime();
        for (int i = 0; i < THREAD_COUNT; i++) {
            normal[i] = new NormalThread();
            normal[i].start();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                normal[i].join();
            } catch (InterruptedException e) {
                System.out.println("Normal thread interrupted.");
            }
        }
        long endTime = System.nanoTime();
        double normalDuration = (endTime - startTime) / 1_000_000_000.0;

        Thread[] synced = new Thread[THREAD_COUNT];
        long syncStart = System.nanoTime();
        for (int i = 0; i < THREAD_COUNT; i++) {
            synced[i] = new SynchronizedThread();
            synced[i].start();
        }
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                synced[i].join();
            } catch (InterruptedException e) {
                System.out.println("Synchronized thread interrupted.");
            }
        }
        long syncEnd = System.nanoTime();
        double syncDuration = (syncEnd - syncStart) / 1_000_000_000.0;

        System.out.printf("Normal thread = %.9f seconds%n", normalDuration);
        System.out.printf("Synchronized thread = %.9f seconds%n", syncDuration);
    }
}

