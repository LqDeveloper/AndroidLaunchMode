package com.example.activitydemo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        launchNormal();
    }

    private void launchNormal() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                LaunchActivity.this.finish();
            }
        }).start();
    }


    private void launchWithTimer() {
        Integer timer = 2000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
                startActivity(intent);
                LaunchActivity.this.finish();
            }
        }, timer);
    }


}
