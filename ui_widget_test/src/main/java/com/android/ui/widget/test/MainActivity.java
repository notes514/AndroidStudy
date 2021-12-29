package com.android.ui.widget.test;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTitle;
    private EditText etDescription;
    private Button btnSend;
    private ImageView ivTemp;
    private ProgressBar pbTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = findViewById(R.id.tv_title);
        etDescription = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);
        ivTemp = findViewById(R.id.iv_temp);
        pbTemp = findViewById(R.id.pb_temp);
        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String str = tvTitle.getText().toString();
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        // 替换图片
        ivTemp.setImageResource(R.drawable.img_1);
        // 进度条
//        if (pbTemp.getVisibility() == VISIBLE) {
//            pbTemp.setVisibility(GONE);
//        } else {
//            pbTemp.setVisibility(VISIBLE);
//        }
        pbTemp.setProgress(pbTemp.getProgress() + 10);
        // AlertDialog
        new AlertDialog.Builder(this)
                .setTitle("This is Dialog")
                .setMessage("Something important")
                .setCancelable(false)
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(this, "点击了 OK", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    Toast.makeText(this, "点击了 Cancel", Toast.LENGTH_SHORT).show();
                })
                .show();
    }
}