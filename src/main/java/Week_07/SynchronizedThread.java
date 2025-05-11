package Week_07;

public class SynchronizedThread extends Thread {
    private static int counter = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            synchronized (SynchronizedThread.class) {
                counter++;
            }
        }
    }
}
