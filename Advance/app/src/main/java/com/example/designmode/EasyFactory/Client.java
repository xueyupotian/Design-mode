package com.example.designmode.EasyFactory;

public class Client {

    public static void main(String[] args) {
        Computer computer = ComputerFactory.createComputer("HP");
        computer.start();
    }

    public static class Lenovo extends Computer {
        @Override
        public void start() {
            System.out.println("联想");
        }
    }

    public static class HP extends Computer {

        @Override
        public void start() {
            System.out.println("惠普");
        }
    }

    public static class Apple extends Computer {
        @Override
        public void start() {
            System.out.println("苹果");
        }
    }

}
