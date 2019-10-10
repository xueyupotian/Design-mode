package com.example.designmode.Handler;

public class ThreadLocalTest {

    public static void main(String[] args) {

        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("123");
        System.out.println("主线程： "+threadLocal.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("abc");
                System.out.println("线程1： "+threadLocal.get());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2： "+threadLocal.get());
            }
        }).start();
    }



}
