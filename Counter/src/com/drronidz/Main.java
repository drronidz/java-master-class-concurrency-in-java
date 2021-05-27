package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/27/2021 , 
    CREATED ON : 10:28 PM
*/

public class Main {
    public static void main(String[] args) {
        Countdown countdown = new Countdown();

        CountdownThread threadOne = new CountdownThread(countdown);
        threadOne.setName("Thread 1");

        CountdownThread threadTwo = new CountdownThread(countdown);
        threadTwo.setName("Thread 2");

        threadOne.start();
        threadTwo.start();
    }
}

class Countdown {
    private int i;
    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {

            case "Thread 1":
                color = ThreadColor.ANSI_CYAN;
                break;

            case "Thread 2":
                color = ThreadColor.ANSI_PURPLE;
                break;

            default:
                color = ThreadColor.ANSI_GREEN;
        }
        synchronized (this) {
            for( i=10; i > 0; i--) {
                System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
            }
        }
    }
}

class CountdownThread extends Thread {
    private Countdown threadCountdown;

    public CountdownThread(Countdown countdown) {
        threadCountdown = countdown;
    }

    public void run() {
        threadCountdown.doCountdown();
    }
}