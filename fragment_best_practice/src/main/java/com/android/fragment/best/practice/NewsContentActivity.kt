package com.android.fragment.best.practice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.fragment.best.practice.fragment.NewsContentFragment
import kotlinx.android.synthetic.main.activity_news_content.*

/**
 * NewsContentActivity
 *
 * @author dhxstart
 * @date 2022/6/15 21:41
 */
class NewsContentActivity : AppCompatActivity() {

    companion object {
        // actionStart() Activity 启动的最佳写法
        fun actionStart(context: Context, title: String, content: String) {
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title", title)
                putExtra("news_content", content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        // 获取传入的新闻标题和内容
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if (title != null && content != null) {
            val fragment = newsContentFrag as NewsContentFragment
            // 刷新 NewsContentFragment 界面
            fragment.refresh(title, content)
        }
    }
}