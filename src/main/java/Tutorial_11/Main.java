package Tutorial_11;

    public class Main {
        public static void main(String[] args) {
            BankAccountWithLock account = new BankAccountWithLock(1000.0);

            // Thread for deposit
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    account.deposit(500);
                    account.getBalance();
                }
            }, "Thread-1");

            // Thread for withdraw
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    account.withdraw(300);
                    account.getBalance();
                }
            }, "Thread-2");

            // Thread for reading balance
            Thread t3 = new Thread(new Runnable() {
                public void run() {
                    account.getBalance();
                }
            }, "Thread-3");

            // Start threads
            t1.start();
            t2.start();
            t3.start();

            // Wait for threads to finish
            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Final balance: " + account.getBalance());
        }
    }
