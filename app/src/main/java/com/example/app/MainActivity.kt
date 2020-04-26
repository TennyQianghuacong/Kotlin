package com.example.app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity
import kotlin.reflect.KProperty

/**
 * @author qhc
 * @time 2020/4/24
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etCode: EditText

    private var usernameSp: String by Saver(usernameKey)
    private var passwordSp: String by Saver(passwordKey)

    class Saver(private var key: String) {
        operator fun getValue(mainActivity: MainActivity, property: KProperty<*>): String {
            return CacheUtils.get(key) ?: ""
        }

        operator fun setValue(mainActivity: MainActivity, property: KProperty<*>, value: String) {
            CacheUtils.save(key, value)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etCode = findViewById(R.id.et_code)

        etUsername.setText(usernameSp)
        etPassword.setText(passwordSp)

        findViewById<Button>(R.id.btn_login).apply {
            setOnClickListener(this@MainActivity)
        }
        findViewById<CodeView>(R.id.code_view).apply {
            setOnClickListener(this@MainActivity)
        }

    }

    override fun onClick(v: View?) {
        if (v is CodeView) {
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString().trim()
        val password = etPassword.text.toString().trim()
        val code = etCode.text.toString()

        val user = User(username, password, code)

        Log.e("QHC", (user.copy() + user).toString())  //测试操作符重载

        //  var (username1, password1, code1) = user //解构

        if (verify(user)) {
            usernameSp = username
            passwordSp = password

            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
        if (user.username?.length ?: 0 < 4) { //Elvis表达式
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password?.length ?: 0 < 4) {
            Utils.toast("密码不合法")
            return false
        }
        return true
    }

}