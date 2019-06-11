package com.example.activitydemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.Activities.SingleInstanceActivity;
import com.example.activitydemo.Activities.SingleTaskActivity;
import com.example.activitydemo.Activities.SingleTopActivity;
import com.example.activitydemo.Activities.StandardActivity;
import com.example.activitydemo.Activities.NormalReturnActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView1 = findViewById(R.id.pushTextView);
        mTextView2 = findViewById(R.id.pushWithReturnTextView);
        mTextView3 = findViewById(R.id.standard);
        mTextView4 = findViewById(R.id.SingleTop);
        mTextView5 = findViewById(R.id.SingleTask);
        mTextView6 = findViewById(R.id.SingleInstance);

        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        mTextView4.setOnClickListener(this);
        mTextView5.setOnClickListener(this);
        mTextView6.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.pushTextView:
                intent = new Intent(MainActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.pushWithReturnTextView:
                intent = new Intent(MainActivity.this, NormalReturnActivity.class);
                intent.putExtra("demo", "这是传过去的值");
                startActivityForResult(intent, 1);
                break;
            case R.id.standard:
                intent = new Intent(MainActivity.this, StandardActivity.class);
                startActivity(intent);
                break;
            case R.id.SingleTop:
                intent = new Intent(MainActivity.this, SingleTopActivity.class);
                startActivity(intent);
                break;
            case R.id.SingleTask:
                intent = new Intent(MainActivity.this, SingleTaskActivity.class);
                startActivity(intent);
                break;
            case R.id.SingleInstance:
                intent = new Intent(MainActivity.this, SingleInstanceActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == 0) {
            if (data == null) return;
            Bundle bundle = data.getExtras();
            String string = bundle.getString("name");
            mTextView2.setText(string);
        }
    }
}
