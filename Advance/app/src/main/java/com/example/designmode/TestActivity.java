package com.example.designmode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    volatile boolean stop = false;
    private TextView mShowTv;
    private int mCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mShowTv = findViewById(R.id.show_text);
        sendMessage();
        //test();
    }

    //1.主线程中通过匿名内部类创建Handler类对象
    private Handler mHandler = new Handler() {
        // 通过复写handlerMessage()从而确定更新UI的操作
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int value = msg.arg1;
                    mShowTv.setText(value+"");
                    break;
                default:
                    break;
            }
        }
    };


    public void sendMessage() {
        new Thread() {
            public void run() {

                while (mCount < 100) {
                    mCount++;
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    //2：创建消息对象
                    Message msg = Message.obtain();
                    msg.what = 1;// 消息标识
                    msg.arg1 = mCount; //消息内容
                    Log.i("TAG", "count值: " + mCount);

                    //3：在工作线程中通过Handler发送消息到消息队列中
                    if (mHandler != null) {
                        mHandler.sendMessage(msg);
                    }
                }
            }
        }.start();
    }

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("lance", "step 0 ");
                Looper.prepare();
                Toast.makeText(TestActivity.this, "run on Thread", Toast.LENGTH_SHORT).show();
                Log.e("lance", "step 1 ");
                Looper.loop();
                //Looper.myLooper().quit();
                Log.e("lance", "step 2 ");
            }
        }).start();
    }

    @Override
    public void finish() {
        super.finish();
        stop = true;
        Log.i("lance", "finish: ");
    }

}
