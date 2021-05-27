package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/27/2021 , 
    CREATED ON : 1:52 PM
*/

import static com.drronidz.ThreadColor.*;

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
//        anotherThread.interrupt();

        Thread myRunnableThreadTwo = new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class's implementation of run()");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + "AnotherThread terminated, or timed out. so I'm running again");
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.println(ANSI_RED + "I could't wait after all. I was interrupted");
                }
            }
        });
        myRunnableThreadTwo.start();


        System.out.println(ANSI_PURPLE + "Hello again from the main thread.");
    }
}
