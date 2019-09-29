package com.example.designmode.Observer;

public class Client {

    public static void main(String[] args){
        WeChatSubjecter subjecter = new WeChatSubjecter();
        WeChatUser user1 = new WeChatUser("王也");
        WeChatUser user2 = new WeChatUser("诸葛青");
        WeChatUser user3 = new WeChatUser("张楚岚");
        subjecter.attach(user1);
        subjecter.attach(user2);
        subjecter.attach(user3);
        subjecter.notify("冯宝宝");
        System.out.println("王也新名字: "+user1.getName());
        System.out.println("诸葛青新名字: "+user2.getName());
        System.out.println("张楚岚新名字: "+user3.getName());
    }

}
