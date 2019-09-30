package com.example.designmode.Mvp.V;

/**
 * @param
 */
public interface ViewInterface {

    String getName();
    String getPw();
    void showToast();
    void hideToast();
    void success();
    void fail();
    void clear();

}
