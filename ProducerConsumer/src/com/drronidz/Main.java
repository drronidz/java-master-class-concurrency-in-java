package com.drronidz;/*
    CREATED BY : ABD EL HALIM
    PROJECT NAME : {IntelliJ IDEA}
    CREATED ON : 5/28/2021 , 
    CREATED ON : 12:23 AM
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.drronidz.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumerOne = new MyConsumer(buffer, ThreadColor.ANSI_GREEN);
        MyConsumer consumerTwo = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        new Thread(producer).start();
        new Thread(consumerOne).start();
        new Thread(consumerTwo).start();

    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyProducer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }
    @Override
    public void run() {
        Random random = new Random();
        String[] nums = { "1","2","3","4","5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.add(num);

                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer as interrupted");
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        buffer.add("EOF");
    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            if(buffer.isEmpty()) {
                continue;
            }
            if (buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
        }
    }
}

