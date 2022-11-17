package com.example.daynight

import android.content.Context
import android.content.res.Configuration

object ThemeUtils {
    /**
     * 是否深色主题
     */
    fun isDarkTheme(context: Context): Boolean {
        val flag = context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return flag == Configuration.UI_MODE_NIGHT_YES
    }
}