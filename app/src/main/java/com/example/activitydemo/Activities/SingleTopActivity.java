package com.example.activitydemo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.R;


/*
* SingleTop和Standrad类似，但有一点不同，就是当将要启动的目标Activity已经位于栈顶的时候，系统不会重新创建新的Activity,而是直接复用已有
* 的Activity,但是如果不是位于栈定的话，就会创建新的Activity
*
* */
public class SingleTopActivity extends AppCompatActivity implements View.OnClickListener{


    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
        setTitle("SingleTop");
        mTextView1 = findViewById(R.id.singleTopPush);
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
            case R.id.singleTopPush:
                 intent = new Intent(SingleTopActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.standardPush:
                 intent = new Intent(SingleTopActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.backTextView:
                finish();
                break;
        }
    }
}
