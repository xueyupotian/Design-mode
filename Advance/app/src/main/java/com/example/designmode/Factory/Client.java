package com.example.designmode.Factory;

/**
 * @param
 */
public class Client {

    public static void main(String[] args) {
        GDComputerFactory computerFactory = new GDComputerFactory();
        Lenovo lenovo = computerFactory.createComputer(Lenovo.class);
        lenovo.start();
        HP hp = computerFactory.createComputer(HP.class);
        hp.start();
        Apple apple = computerFactory.createComputer(Apple.class);
        apple.start();
        HW hw = computerFactory.createComputer(HW.class);
        hw.start();
    }

    public static class Lenovo extends Computer {
        @Override
        public void start() {
            System.out.println("联想电脑启动");
        }
    }

    public static class HP extends Computer {

        @Override
        public void start() {
            System.out.println("惠普电脑启动");
        }
    }

    public static class Apple extends Computer {
        @Override
        public void start() {
            System.out.println("苹果电脑启动");
        }
    }

    public static class HW extends Computer {
        @Override
        public void start() {
            System.out.println("华为电脑启动");
        }
    }

}
