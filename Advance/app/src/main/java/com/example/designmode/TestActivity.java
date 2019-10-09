package com.example.designmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TestActivity extends AppCompatActivity {

    boolean stop = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        test();
    }

    public void test(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i=0;
                while (!stop){
                    i++;
                    Log.i("lance", "run: "+i);
                }
            }
        }).start();
    }

    @Override
    public void finish() {
        super.finish();
        stop = true;
    }
}
