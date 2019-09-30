package com.example.designmode.Mvp.M;

import android.net.IpSecManager;

/**
 * @param
 */
public class MImplement implements Minterface {
    @Override
    public void login(final String name, final String pw, final OnLoginListener loginListener) {
         new Thread(new Runnable() {
             @Override
             public void run() {
                 try{
                      Thread.sleep(2000);
                 }catch (Exception e){
                     e.printStackTrace();
                 }

                 if (name.equals("abc") && pw.equals("123")){
                     User user= new User();
                     user.setName(name);
                     user.setPassword(pw);
                     loginListener.loginSuccess(user);
                 }else {
                     loginListener.loginFail();
                 }

             }
         }).start();
    }
}
