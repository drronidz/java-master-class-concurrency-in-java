package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/29/2021 , 
    CREATED ON : 1:02 AM
*/

public class Main {
    public static void main(String[] args) {

        final Worker workerOne = new Worker("Worker 1", true);
        final Worker workerTwo = new Worker("Worker 2", true);

        final SharedResource sharedResource = new SharedResource(workerOne);

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerOne.work(sharedResource, workerTwo);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                workerTwo.work(sharedResource, workerOne);
            }
        }).start();

    }
}
