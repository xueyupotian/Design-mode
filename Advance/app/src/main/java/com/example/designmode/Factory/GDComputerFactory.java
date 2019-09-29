package com.example.designmode.Factory;

/**
 * @param
 */
public class GDComputerFactory extends ComputerFactory {

    @Override
    public <T extends Computer> T createComputer(Class<T> clazz) {
        //因为如果是简单工厂模式，每次新增一个厂商，都要修改工厂类的switch,违反了 开放封闭原则
        Computer computer = null;
        String className = clazz.getName();
        try {
            computer = (Computer) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) computer;
    }

}
