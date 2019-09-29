package com.example.designmode.Observer;

public class WeChatUser implements Observer {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public WeChatUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String name) {
        this.name = name;
    }
}
