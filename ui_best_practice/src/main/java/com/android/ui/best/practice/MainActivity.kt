package com.android.ui.best.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val msgList = ArrayList<Msg>()
    // lateinit 关键字为延迟初始化
    private lateinit var adapter: MsgAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized) {
            adapter = MsgAdapter(msgList)
        }
        recyclerView.adapter = adapter
        btnSend.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v) {
            btnSend -> {
                val message = etMessage.text.toString()
                if (message.isNotEmpty()) {
                    val msg = Msg(message, Msg.TYPE_SENT)
                    msgList.add(msg)
                    // 当有新消息时，刷新RecyclerView中的显示
                    adapter.notifyItemInserted(msgList.size - 1)
                    // 将RecyclerView定位到最后一行
                    recyclerView.scrollToPosition(msgList.size - 1)
                    // 清空输入框中的内容
                    etMessage.setText("")
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("Hello guy", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. who is that?", Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}