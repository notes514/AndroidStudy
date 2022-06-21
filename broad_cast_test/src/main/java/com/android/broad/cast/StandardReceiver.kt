package com.android.broad.cast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class StandardReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "received in StandardReceiver...", Toast.LENGTH_SHORT).show()
        // 将这条广播进行截断，后边的BroadcastReceiver将无法接收
        abortBroadcast()
    }
}