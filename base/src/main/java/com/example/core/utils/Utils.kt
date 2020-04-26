package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * @author qhc
 * @time 2020/4/24
 */
object Utils {

    private val displayMetrics = Resources.getSystem().displayMetrics

    fun Float.dp2px(): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)
    }

    fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {//参数默认值，替换Java重构
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }

}