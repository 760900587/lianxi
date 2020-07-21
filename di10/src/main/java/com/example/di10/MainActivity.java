package com.example.di10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText user;
    private EditText psw;
    private CheckBox ji;
    private Button deng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getActionBar().hide();

    }

    private void initView() {
        user = (EditText) findViewById(R.id.user);
        psw = (EditText) findViewById(R.id.psw);
        ji = (CheckBox) findViewById(R.id.ji);
        deng = (Button) findViewById(R.id.deng);
        deng.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deng:
                String s1 = user.getText().toString();
                String s2 = psw.getText().toString();
                if (s1.equals("admin")&&s2.equals("123456")){
                startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }else{
                    Toast.makeText(MainActivity.this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
