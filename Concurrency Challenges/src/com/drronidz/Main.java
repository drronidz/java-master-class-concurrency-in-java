package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/31/2021 , 
    CREATED ON : 11:30 PM
*/

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345-678", 1000.00);

        // Create and start the threads here...

//        Thread threadOne = new Thread() {
//            @Override
//            public void run() {
//                account.deposit(300.00);
//                account.withdraw(50.00);
//            }
//        };
//
//        Thread threadTwo = new Thread() {
//            @Override
//            public void run() {
//                account.deposit(203.75);
//                account.withdraw(100.00);
//            }
//        };
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(300.00);
                account.withdraw(50.00);
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                account.deposit(203.75);
                account.withdraw(100.00);
            }
        });

        threadOne.start();
        threadTwo.start();
    }

}
