package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/28/2021 , 
    CREATED ON : 3:32 PM
*/

import javax.crypto.spec.PSource;

public class Main {

    public static Object lockOne = new Object();
    public static Object lockTwo = new Object();

    public static void main(String[] args) {
        new ThreadOne().start();
        new ThreadTwo().start();

    }
    private static class ThreadOne extends Thread {

        @Override
        public void run() {
            synchronized (lockOne) {
                System.out.println("Thread 1: Has lockOne");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1: Waiting for lockTwo");
                synchronized (lockTwo) {
                    System.out.println("Thread 1: Has lockOne and lockTwo");
                }
                System.out.println("Thread 1: Released lockTwo");
            }
            System.out.println("Thread 1: Released lockOne. Exiting...");
        }
    }
    private static class ThreadTwo extends Thread {

        @Override
        public void run() {
            synchronized (lockOne) {
                System.out.println("Thread 2: has lockOne");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2: Waiting for lockTwo");
                synchronized (lockTwo) {
                    System.out.println("Thread 2: Has lockTwo and lockTwo");
                }
                System.out.println("Thread 2: Released lockTwo");
            }
            System.out.println("Thread 2: Released lockOne. Exiting...");
        }

    }
}


