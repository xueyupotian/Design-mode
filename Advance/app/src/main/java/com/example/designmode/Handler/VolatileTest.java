package com.example.designmode.Handler;

public class VolatileTest {

    public volatile int index = 0;

    public void increase() {
        //自增操作是不具备原子性的，它包括读取变量的原始值、加1、写入工作内存
        index++;
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        test.increase();
                    }
                }
            }).start();
        }

        //如果有子线程就让出资源，保证所有子线程都执行完
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(test.index);
    }

}
