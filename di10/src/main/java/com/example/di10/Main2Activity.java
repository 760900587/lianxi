package com.example.di10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView my;
    private ArrayList<ReanBean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        //创建子线程
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://www.wanandroid.com/banner/json").openConnection();
                    conn.setRequestMethod("GET");
                    int code = conn.getResponseCode();
                    if (code==200){
                        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        StringBuffer buffer = new StringBuffer();
                        String b;
                        while ((b=reader.readLine())!=null){
                            buffer.append(b);
                        }
                        String json = buffer.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void initView() {
        //获取控件对象
        my = (ListView) findViewById(R.id.my);
        //初始化数据
        list = new ArrayList<>();
        //创建适配器
        item_Adapter adapter = new item_Adapter(this, list);
        //绑定适配器
        my.setAdapter(adapter);
    }
}
