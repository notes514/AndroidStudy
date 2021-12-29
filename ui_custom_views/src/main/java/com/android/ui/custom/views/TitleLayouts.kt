package com.android.ui.custom.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.LinearLayoutCompat

class TitleLayouts(context: Context, attrs: AttributeSet) : LinearLayoutCompat(context, attrs) {

    init {
        LayoutInflater.from(context).inflate(R.layout.title, this)
    }
}