package com.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Log.d(TAG, "Task id is taskId：" + getTaskId());
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
//        view.setOnClickListener(v -> returnPrevious());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 此方法用于启动 Activity（启动一个 Activity 的最佳写法，建议每个 Activity 都附上）
     * @param context 上下文
     * @param data data数据
     * @param action action数据
     */
    public static void actionStart(Context context, String data, String action) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("param1", data);
        intent.putExtra("param2", action);
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        returnPrevious();
    }
}