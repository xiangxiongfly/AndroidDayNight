package com.example.daynight

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        toNoUiModeActivity.setOnClickListener {
            startActivity(Intent(this@MainActivity, NoUiModeActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if (ThemeUtils.isDarkTheme(this)) {
            imageView.setImageResource(R.drawable.dark)
        } else {
            imageView.setImageResource(R.drawable.light)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("TAG", "Activity onDestroy()")
    }
}