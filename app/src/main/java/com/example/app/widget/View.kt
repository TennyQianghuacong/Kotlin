package com.example.app.widget

import android.util.Log

/**
 * @author qhc
 * @time 2020/4/27
 */
class View {

    val value = 3

    fun onClick(body: (v: View) -> Unit) {
        body.invoke(this)
    }
}

fun main() {

    var view = View()
    view.onClick { v -> click(v) }


}

fun click(v: View) {
    println("value: ${v.value}")
}