package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/29/2021 , 
    CREATED ON : 1:03 AM
*/

public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public synchronized void work(SharedResource sharedResource, Worker otherWorker) {
        while (active) {
            if(sharedResource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            if(otherWorker.isActive()) {
                System.out.println(getName() + " : give the resource to the worker " + otherWorker);
                sharedResource.setOwner(otherWorker);
                continue;
            }
            System.out.println(getName() + ": working on common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
