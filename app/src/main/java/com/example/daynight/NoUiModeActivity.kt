package com.example.daynight

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_no_ui_mode.*

class NoUiModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_ui_mode)
        Log.e("TAG", "Activity onCreate()")
        initView()
    }

    private fun initView() {
        btnLight.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        btnDark.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        btnSystem.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
    }

    //监听系统深色模式切换
    override fun onConfigurationChanged(newConfig: Configuration) {
        Log.e("TAG", "onConfigurationChanged:")
        super.onConfigurationChanged(newConfig)
        val currentNightMode = newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when (currentNightMode) {
            Configuration.UI_MODE_NIGHT_NO -> {
                // 夜间模式未启用，我们正在使用浅色主题
                textView.setText("当前浅色模式")
            }
            Configuration.UI_MODE_NIGHT_YES -> {
                // 夜间模式启用，我们使用的是深色主题
                textView.setText("当前深色模式")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "Activity onDestroy()")
    }
}