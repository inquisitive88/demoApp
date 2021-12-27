package com.test.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.test.MyApplication
import com.test.util.PrefUtils
import com.test.util.Util
import com.test.errorProvider.ErrorProvider
import com.test.errorProvider.ErrorProviderImpl

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: MyApplication) {

    // region Global Use
    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideErrorProvider(): ErrorProvider {
        return ErrorProviderImpl(application.applicationContext)
    }

    @Singleton
    @Provides
    fun provideUtil(): Util = Util(application.applicationContext)

    @Singleton
    @Provides
    fun PrefUtils(): PrefUtils = PrefUtils(application.applicationContext)


}