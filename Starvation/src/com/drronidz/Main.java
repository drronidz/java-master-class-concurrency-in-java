package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/29/2021 , 
    CREATED ON : 12:17 AM
*/

import java.util.concurrent.locks.ReentrantLock;

public class Main {

    private static ReentrantLock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        Thread threadOne = new Thread(new Worker(ThreadColor.ANSI_PURPLE), "Priority 10");
        Thread threadTwo = new Thread(new Worker(ThreadColor.ANSI_BLUE), "Priority 8");
        Thread threadThree = new Thread(new Worker(ThreadColor.ANSI_GREEN), "Priority 6");
        Thread threadFour = new Thread(new Worker(ThreadColor.ANSI_CYAN), "Priority 4");
        Thread threadFive = new Thread(new Worker(ThreadColor.ANSI_RED), "Priority 2");

        threadOne.setPriority(10);
        threadTwo.setPriority(8);
        threadThree.setPriority(6);
        threadFour.setPriority(4);
        threadFive.setPriority(2);

        threadThree.start();
        threadTwo.start();
        threadFive.start();
        threadFour.start();
        threadOne.start();

    }
    private static class Worker implements Runnable {
        private int runCount = 1;
        private String threadColor;

        public Worker(String threadColor) {
            this.threadColor = threadColor;
        }

        @Override
        public void run() {
            for(int i=0; i<100; i++) {
                lock.lock();
                try {
                    System.out.format(threadColor + "%s: runCount = %d\n",
                            Thread.currentThread().getName(),
                            runCount++);
                    // execute critical section of code
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
