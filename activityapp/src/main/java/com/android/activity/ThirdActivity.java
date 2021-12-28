package com.android.activity;

import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Task id is taskId：" + getTaskId());
        setContentView(R.layout.third_layout);

        Button btnThree = findViewById(R.id.btn_three);
        btnThree.setOnClickListener(v -> {
            ActivityController.getInstance().finishAllActivities();
            // 杀掉当前进程的代码，以保证程序完全退出
            // 注意：killProcess() 只能用于杀掉当前程序，不能用于杀掉其它程序
            Process.killProcess(Process.myPid());
        });
    }
}