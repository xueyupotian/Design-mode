package com.example.designmode.EasyFactory;

/**
 * @param
 */
public class ComputerFactory {

    public static Computer createComputer(String type) {
        Computer computer = null;
        switch (type) {
            case "HP":
                computer = new Client.HP();
                break;
            case "Lenovo":
                computer = new Client.Lenovo();
                break;
            case "Apple":
                computer = new Client.Apple();
                break;
        }
        return computer;
    }

}
