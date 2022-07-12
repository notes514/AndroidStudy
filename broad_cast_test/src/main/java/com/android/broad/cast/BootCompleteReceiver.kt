package com.android.broad.cast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        Toast.makeText(context, "This method is called when the BroadcastReceiver " +
                "is receiving an Intent broadcast.", Toast.LENGTH_SHORT).show()
    }
}