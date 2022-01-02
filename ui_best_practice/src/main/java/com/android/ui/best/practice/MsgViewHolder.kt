package com.android.ui.best.practice

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * sealed 关键字用于构造一个密封类
 */
sealed class MsgViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    class LeftViewHolder(view: View) : MsgViewHolder(view) {
        val leftMsg: TextView = view.findViewById(R.id.leftMsg)
    }

    class RightViewHolder(view: View) : MsgViewHolder(view) {
        val rightMsg: TextView = view.findViewById(R.id.rightMsg)
    }
}