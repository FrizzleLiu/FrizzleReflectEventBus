package com.frizzle.frizzlereflecteventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.frizzle.eventbus_library.EventBus;
import com.frizzle.frizzlereflecteventbus.bean.EventBean;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Thread() {
//                    @Override
//                    public void run() {
//                        Log.e("EventBus >>2>> ", "thread = " + Thread.currentThread().getName());
//                        EventBus.getDefault().post(new EventBean("EventBus"));
//                    }
//                }.start();
                Log.e("EventBus >>2>> ", "thread = " + Thread.currentThread().getName());
                EventBus.getDefault().post(new EventBean("frizzle"));
            }
        });
    }
}