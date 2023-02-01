package com.koko.dataStructures.Misc;

public class PrintEvenOddUsingThreads {

    static int N = 100;
    static int counter = 1;

    public void printsOdd() throws InterruptedException {
        synchronized (this){
            while(counter <= N){
                while(counter%2 == 0) {
                    wait();
                }
                System.out.println(counter++);
                notify();
            }
        }
    }

    public void printsEven() throws InterruptedException {
        synchronized (this){
            while(counter <= N){
                while(counter%2 != 0) {
                    wait();
                }
                System.out.println(counter++);
                notify();
            }
        }
    }
    public static void main(String[] args) {

        PrintEvenOddUsingThreads p = new PrintEvenOddUsingThreads();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.printsOdd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.printsEven();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
    }
}
