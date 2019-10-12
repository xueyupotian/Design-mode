package com.example.designmode.Handler;

/**
 * @param
 */
public class SingleInstance {

    private volatile static SingleInstance instance;

    public static SingleInstance getInstance() {
        if (instance == null) {
            synchronized (SingleInstance.class) {
                if (instance == null) {
                    instance = new SingleInstance();
                }
            }
        }
        return instance;
    }

    //a. memory = allocate() //分配内存
    //b. initInstance(memory) //初始化对象
    //c. instance = memory //设置instance指向刚分配的地址

    //https://www.cnblogs.com/monkeysayhi/p/7654460.html
    //https://blog.csdn.net/u012723673/article/details/80682208
}
