package com.example.activitydemo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.activitydemo.R;

public class NormalReturnActivity extends AppCompatActivity implements View.OnClickListener{
   TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_return);

        mTextView = findViewById(R.id.normalReturn);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("demo");

        mTextView.setText(name);
        mTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = getIntent();
        intent.putExtra("name","这是点击了返回");
        NormalReturnActivity.this.setResult(0,intent);
        finish();
    }
}
