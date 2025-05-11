package Week_07;

public class TestAtomicInteger1p {
    public static void main(String[] args) throws InterruptedException {
        CountProblem pt = new CountProblem();
        Thread t1 = new Thread(pt, "t1");//New Modification
        t1.start();
        t1.join();


        System.out.println("Count=" + pt.getCount());


    }
}
