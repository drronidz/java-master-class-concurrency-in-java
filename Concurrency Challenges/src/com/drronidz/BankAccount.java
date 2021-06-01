package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/31/2021 , 
    CREATED ON : 11:30 PM
*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {


    private String accountNumber;
    private double balance;

    private Lock lock;

    private String here;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.lock = new ReentrantLock();
        this.here = "0";
    }

//    public synchronized void deposit(double amount) {
//        balance += amount;
//    }
//
//    public synchronized void withdraw(double amount) {
//        balance -= amount;
//    }

    public void deposit(double amount) {

//        synchronized (this) {
//            balance += amount;
//        }

//        lock.lock();
//        try {
//            balance += amount;
//        } finally {
//            lock.unlock();
//        }

        boolean status = false;
        try {
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            // do something here
        }
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {

//        synchronized (this) {
//            balance -= amount;
//        }

//        lock.lock();
//        try {
//            balance -= amount;
//        } finally {
//            lock.unlock();
//        }
        boolean status = false;
        try {
            if(lock.tryLock(1000,TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    status = true;
                } finally {
                    lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            // do something here
        }
        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number = : " + accountNumber);
    }
}
