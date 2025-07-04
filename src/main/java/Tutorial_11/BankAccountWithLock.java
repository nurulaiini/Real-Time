package Tutorial_11;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;

    public class BankAccountWithLock {
        private double balance;

        private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        private final Lock readLock = rwLock.readLock();
        private final Lock writeLock = rwLock.writeLock();

        // Constructor
        public BankAccountWithLock(double initialBalance) {
            this.balance = initialBalance;
        }

        // Read the balance (shared read lock)
        public double getBalance() {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " reads balance: " + balance);
                return balance;
            } finally {
                readLock.unlock();
            }
        }

        // Deposit money (exclusive write lock)
        public void deposit(double amount) {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " deposits: " + amount);
                balance += amount;
            } finally {
                writeLock.unlock();
            }
        }

        // Withdraw money (exclusive write lock)
        public void withdraw(double amount) {
            writeLock.lock();
            try {
                if (balance >= amount) {
                    System.out.println(Thread.currentThread().getName() + " withdraws: " + amount);
                    balance -= amount;
                } else {
                    System.out.println(Thread.currentThread().getName() + " insufficient funds for: " + amount);
                }
            } finally {
                writeLock.unlock();
            }
        }
    }
