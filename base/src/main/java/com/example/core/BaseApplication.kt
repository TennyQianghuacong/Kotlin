package com.example.core

import android.app.Application
import android.content.Context

/**
 * @author qhc
 * @time 2020/4/26
 */
class BaseApplication : Application() {

    companion object {
        lateinit var currentApplication: Context
    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }

}