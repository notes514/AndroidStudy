package com.android.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    private static final String TAG = "FirstActivity";
    public static final String EXTRA_BTN_TWO = "btn_two_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 打印当前返回栈的ID
        Log.d(TAG, "task id is taskId：" + getTaskId());
        // 给当前Activity加载一个布局，注意：在项目中添加的任何资源都会在 R 文件中添加生成相对的资源id
        setContentView(R.layout.first_layout);

        // findViewById()：获取布局文件中控件的实例
        Button btnOne = findViewById(R.id.btn_one);
        Button btnTwo = findViewById(R.id.btn_two);
        // 注册监听器
        sendBtnOne(btnOne);
        sendBtnTwo(btnTwo);
    }

    /**
     * 此方法用于描述Activity的显示和隐式跳转
     *
     * @param view view
     */
    public void sendBtnOne(View view) {
        view.setOnClickListener(v -> {
            // 显示 Intent，意图非常明显，直接跳转到目标SecondActivity上
//            Intent intent = new Intent(this, SecondActivity.class);

            // 隐式 Intent，意图不明显
//            Intent intent = new Intent("com.android.activity.ACTION_START");
            // action只能添加一个，但是category可以添加多个，需要注意在清单文件中对category进行同步
//            intent.addCategory("com.android.activity.MY_CATEGORY");
//
            // 隐式 Intent的其他用法，打开一个网页
//            Intent intent = new Intent(Intent.ACTION_VIEW);
            // setData() 用于接收一个Uri对象，通过Uri.parse()进行解析
//            intent.setData(Uri.parse("https://www.baidu.com"));

            Intent intent = new Intent(Intent.ACTION_DIAL);
            // 指定其他协议，例如：geo（显示地理位置）、tel（拨打电话）
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        });
    }

    public void sendBtnTwo(View view) {
        view.setOnClickListener(v -> {
            String message = "Hello SecondActivity！！！";
            // 使用显示方法传递数据
//            Intent intent = new Intent(this, SecondActivity.class);
//            intent.putExtra(EXTRA_BTN_TWO, message);
//            startActivity(intent);

            // 返回数据给上一个activity
            Intent intent = new Intent(this, SecondActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    String resultDate = data.getStringExtra("result_data");
                    Log.d(TAG, "result data is " + resultDate);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}