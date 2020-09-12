package com.frizzle.frizzlereflecteventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.frizzle.eventbus_library.EventBus;
import com.frizzle.eventbus_library.annotation.Subscribe;
import com.frizzle.eventbus_library.mode.ThreadMode;
import com.frizzle.frizzlereflecteventbus.bean.EventBean;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND) // 默认不填线程
    public void getMessage(EventBean bean) {
        Log.e("EventBus >>1>> ", "thread = " + Thread.currentThread().getName());
        Log.e("EventBus >>1>> ", "" + bean.getName());
    }
}