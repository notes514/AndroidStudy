package com.android.ui.best.practice

class Msg(val message: String, val type: Int) {

    companion object {
        // const 关键字用于定义常量，注意：只有在单例类、companion object或者顶层方法中才可以使用
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}