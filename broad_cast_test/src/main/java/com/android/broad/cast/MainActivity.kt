package com.android.broad.cast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var timeChangeReceiver: TimeChangeReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter()
        // 当系统发生变化时，会发出 android.intent.action.TIME_TICK 的广播
        intentFilter.addAction("android.intent.action.TIME_TICK")
        timeChangeReceiver = TimeChangeReceiver()
        registerReceiver(timeChangeReceiver, intentFilter)

        // 自定义广播（标准广播）
        btn_standard.setOnClickListener {
            val intent = Intent("com.android.broad.cast.STANDARD_RECEIVER")
            // 传入当前应用程序的包名
            intent.setPackage(packageName)
            // Android8.0之后，静态注册的 BroadcastReceiver 是无法接受隐式广播，需要通过setPackage来实现
            // 发起标准广播的方式
//            sendBroadcast(intent)
            // 发起有序广播的方式
            sendOrderedBroadcast(intent, null)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(timeChangeReceiver)
    }

    // inner class 表示定义内部类
    inner class TimeChangeReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent?) {
            Toast.makeText(context, "Time has change...", Toast.LENGTH_SHORT).show()
        }
    }
}