package com.android.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        String message = getIntent().getStringExtra(FirstActivity.EXTRA_BTN_TWO);
        Log.d(TAG, "extra data is " + message);

        Button btnSecondOne = findViewById(R.id.btn_second_one);
        sendSecondBtnOne(btnSecondOne);
    }

    public void returnPrevious() {
        Intent intent = new Intent();
        intent.putExtra("result_data", "Hello FirstActivity");
        // 此方法专门用于向上一个 Activity 返回数据
        setResult(RESULT_OK, intent);
        finish();
    }

    public void sendSecondBtnOne(View view) {
        view.setOnClickListener(v -> returnPrevious());
    }

    @Override
    public void onBackPressed() {
        returnPrevious();
    }
}