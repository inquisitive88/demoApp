package com.test

import android.app.Application
import com.test.di.DaggerProvider
import com.test.di.component.AppComponent


class MyApplication : Application() {
    private lateinit var mAppComponent: AppComponent

    init {
        instance_ = this
    }

    companion object {
        lateinit var instance_: MyApplication

        fun getInstance() = instance_
    }

    override fun onCreate() {
        super.onCreate()
        DaggerProvider.initComponent(this)
        DaggerProvider.getAppComponent()?.inject(this)
    }

}