package com.example.designmode.Factory;

/**
 * @param
 */
public abstract class ComputerFactory {

    public abstract <T extends Computer> T createComputer(Class<T> clazz);

}
