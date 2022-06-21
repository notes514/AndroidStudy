package com.android.fragment.best.practice.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.fragment.best.practice.R
import kotlinx.android.synthetic.main.news_content_frag.*

/**
 * NewsContentActivity
 *
 * @author dhxstart
 * @date 2022/6/15 21:06
 */
class NewsContentFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_content_frag, container, false)
    }

    fun refresh(title: String, content: String) {
        contentLayout.visibility = View.VISIBLE
        // 刷新新闻标题
        newsTitle.text = title
        // 刷新新闻内容
        newsContent.text = content
    }
}