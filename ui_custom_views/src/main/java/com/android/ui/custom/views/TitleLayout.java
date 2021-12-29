package com.android.ui.custom.views;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

public class TitleLayout extends LinearLayoutCompat {
    private Button btnBack;
    private TextView tvTitle;
    private Button btnEdit;

    public TitleLayout(Context context) {
        super(context);
    }

    public TitleLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.title, this);
        btnBack = view.findViewById(R.id.btn_back);
        tvTitle = view.findViewById(R.id.tv_title);
        btnEdit = view.findViewById(R.id.btn_edit);

        btnBack.setOnClickListener(v -> {
            Activity mActivity = (Activity) context;
            mActivity.finish();
        });
        btnEdit.setOnClickListener(v -> {
            Toast.makeText(context, "You Clicked Edit Button", Toast.LENGTH_SHORT).show();
        });
    }
}
