package com.example.activitydemo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.R;


/*
* SingleTask 保证Activity在一个Task只能有一个实例，可以分为三种情况
*
* 1.如果将要启动的目标Activity不存在，系统将会创建目标Activity实例，并将它加入到Task栈顶
*
* 2.如果将要启动的目标Activity已经位于栈顶，此时效果和SingleTop一样
*
* 3.如果将要启动的Activity已经存在但是不在栈顶，系统将会把位于该Activity上的所有Activity移除Task ,从而使其转入栈顶
*
* */
public class SingleTaskActivity extends AppCompatActivity implements View.OnClickListener{



    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
        setTitle("SingleTask");
        mTextView1 = findViewById(R.id.singleTaskPush);
        mTextView2 = findViewById(R.id.standardPush);
        mTextView3 = findViewById(R.id.backTextView);
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.singleTaskPush:
                intent = new Intent(SingleTaskActivity.this, SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.standardPush:
                intent = new Intent(SingleTaskActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.backTextView:
                finish();
                break;
        }
    }
}
