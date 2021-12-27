@file:Suppress("Annotator")

package com.test.di

import com.test.MyApplication
import com.test.di.component.AppComponent
import com.test.di.component.DaggerAppComponent
import com.test.di.modules.ApplicationModule


class DaggerProvider {

    companion object {
        private var appComponent: AppComponent? = null

        fun initComponent(application: MyApplication) {
            appComponent = DaggerAppComponent.builder()
                .applicationModule(ApplicationModule(application))
                .build()
        }

        fun getAppComponent(): AppComponent? {
            return appComponent
        }

    }
}