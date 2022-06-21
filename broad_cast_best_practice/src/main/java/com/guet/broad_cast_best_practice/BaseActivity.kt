package com.guet.broad_cast_best_practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity 基类，open class 表示可继承
 *
 * @author dhxstart
 * @date 2022/7/10 22:26
 */
open class BaseActivity : AppCompatActivity() {

    // lateinit var 修饰的变量的初始化时机自由决定
    lateinit var receiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        ActivityCollector.addActivity(this)
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.android.broad.cast.FORCE_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("Warning")
                setMessage("You are forced to be offline. Please try to login again.")
                setCancelable(false)
                setPositiveButton("OK") {_, _, ->
                    // 销毁所有Activity
                    ActivityCollector.finishAll()
                    val i = Intent(context, LoginActivity::class.java)
                    // 重新启动LoginActivity
                    startActivity(i)
                }
                show()
            }
        }
    }
}