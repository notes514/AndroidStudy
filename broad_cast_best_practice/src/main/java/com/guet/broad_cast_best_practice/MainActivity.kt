package com.guet.broad_cast_best_practice

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forceOffline.setOnClickListener {
            val intent = Intent("com.android.broad.cast.FORCE_OFFLINE")
            sendBroadcast(intent)
        }
    }
}