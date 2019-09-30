package com.example.designmode.Mvp.P;

import android.os.Handler;

import com.example.designmode.Mvp.M.MImplement;
import com.example.designmode.Mvp.M.Minterface;
import com.example.designmode.Mvp.M.OnLoginListener;
import com.example.designmode.Mvp.M.User;
import com.example.designmode.Mvp.V.ViewInterface;


/**
 * @param
 */
public class UserLoginPresenter {


    //https://blog.csdn.net/lmj623565791/article/details/46596109
    private ViewInterface viewInterface; //View的接口
    private Minterface minterface; //M的接口
    private Handler mHandler=new Handler();

    public UserLoginPresenter(ViewInterface viewInterface) {
        this.viewInterface = viewInterface;
        this.minterface = new MImplement();
    }

    public void login(){
        viewInterface.showToast();
        minterface.login(viewInterface.getName(), viewInterface.getPw(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewInterface.success();
                        viewInterface.hideToast();
                    }
                });
            }

            @Override
            public void loginFail() {
                 mHandler.post(new Runnable() {
                     @Override
                     public void run() {
                         viewInterface.fail();
                         viewInterface.hideToast();
                     }
                 });
            }
        });
    }


    public void clear(){
        viewInterface.clear();
    }

}
