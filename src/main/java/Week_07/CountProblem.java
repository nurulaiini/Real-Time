package Week_07;

public class CountProblem implements Runnable {
    private int count;
    public void run(){
        for (int i = 0; i< 10; i++){ //New Modification
            processSomething(i);
            count++;
        }
    }
    public int getCount(){
        return this.count;
    }
    private void processSomething(int i){
        try {
            Thread.sleep(i * 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
