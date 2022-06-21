package com.guet.broad_cast_best_practice

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 用户登录Activity
 *
 * @author dhxstart
 * @date 2022/7/10 22:32
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_login)
        login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            if (username == "admin" && password == "123456") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "username or password is invalid", Toast.LENGTH_SHORT).show()
            }
        }
    }
}