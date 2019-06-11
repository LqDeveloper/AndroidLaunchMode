package com.example.activitydemo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.R;


/*
* SingleInstance 无论从哪个Task启动Activity，只会创建一个目标Activity，并使用一个全新的Task栈来加载Activity
*
* 1.如果将要启动的Activity不存在，。系统会创建一个全新的Task，再创建目标Activity，并将它加入新的task的栈顶
*
* 2.如果将要启动的Activity已经存在，无论位于哪个应用程序中，位于哪个Task中，系统都会把该Activity所在的task转到前台，从而是该Activity显示
* 出来
*
*
*
* */
public class SingleInstanceActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
        setTitle("SingleInstance");
        mTextView1 = findViewById(R.id.standardPush);
        mTextView2 = findViewById(R.id.singleInstancePush);
        mTextView3 = findViewById(R.id.backTextView);
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.standardPush:
                intent = new Intent(SingleInstanceActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.singleInstancePush:
                intent = new Intent(SingleInstanceActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
                break;
            case R.id.backTextView:
                finish();
                break;
        }
    }
}
