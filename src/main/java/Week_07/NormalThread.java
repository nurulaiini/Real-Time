package Week_07;

public class NormalThread extends Thread {
    private static int counter = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000; j++) {
            counter++; // no synchronization
        }
    }
}