package com.example.designmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.designmode.Mvp.P.UserLoginPresenter;
import com.example.designmode.Mvp.V.ViewInterface;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    private EditText editText1;
    private EditText editText2;
    private Button editText3;
    private Button editText4;
    private ProgressBar progressBar;
    private UserLoginPresenter userLoginPresenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 =findViewById(R.id.text1);
        editText2 =findViewById(R.id.text2);
        editText3 =findViewById(R.id.text3);
        editText4 =findViewById(R.id.text4);
        progressBar = findViewById(R.id.pro);
        editText3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.login();
            }
        });
        editText4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userLoginPresenter.clear();
            }
        });
    }


    @Override
    public String getName() {
        return editText1.getText().toString().trim();
    }

    @Override
    public String getPw() {
        return editText2.getText().toString().trim();
    }

    @Override
    public void showToast() {
         progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideToast() {
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void success() {
        Toast.makeText(this,
                " login success , to MainActivity", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void fail() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
         editText1.setText("");
         editText2.setText("");
    }

}
