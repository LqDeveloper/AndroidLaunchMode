package com.example.activitydemo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.R;



/*
* 这种模式不会启动新的Task,新创建的Activity会被添加到原有的Task中
* 和iOS 中的UINavigationViewController相似
* */

public class StandardActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        setTitle("Standard");
        mTextView1 = findViewById(R.id.standardPush);
        mTextView2 = findViewById(R.id.standardBack);
        mTextView3 = findViewById(R.id.singleTop);
        mTextView4 = findViewById(R.id.singleTask);
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.standardPush:
                 intent = new Intent(StandardActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.singleTop:
                intent = new Intent(StandardActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.singleTask:
                intent = new Intent(StandardActivity.this, SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.standardBack:
                finish();
                break;
        }
    }
}
