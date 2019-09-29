package com.example.designmode.Observer;

public interface Subject {

    /**
     * 增加订阅者
     * @param observer
     */
    void attach(Observer observer);

    /**
     * 删除订阅者
     * @param observer
     */
    void detach(Observer observer);

    /**
     * 通知订阅者
     * @param
     */
    void notify(String message);

}
