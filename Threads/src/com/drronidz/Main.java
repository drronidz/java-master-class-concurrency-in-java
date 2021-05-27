package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/27/2021 , 
    CREATED ON : 1:52 PM
*/

import static com.drronidz.ThreadColor.ANSI_GREEN;
import static com.drronidz.ThreadColor.ANSI_PURPLE;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread.");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("== Another Thread ==");
        anotherThread.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");

//        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from the anonymous class thread.");
            }
        }.start();

        Thread myRunnableThreadOne = new Thread(new MyRunnable());
        myRunnableThreadOne.start();

        Thread myRunnableThreadTwo = new Thread(new MyRunnable(){
            @Override
            public void run() {
                super.run();
            }
        });
        myRunnableThreadTwo.start();

        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
    }
}
