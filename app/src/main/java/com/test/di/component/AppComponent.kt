package com.test.di.component
import com.test.MyApplication
import com.test.di.modules.ApplicationModule
import com.test.di.modules.NetworkModule
import com.test.di.modules.ViewModules.ViewModelFactoryModule
import com.test.di.modules.ViewModules.ViewModelModule
import com.test.home.view.DetailActivity
import com.test.home.view.HomeActivity


import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class, ViewModelModule::class, ViewModelFactoryModule::class
    ]
)

interface AppComponent{
    fun inject(myApplication: MyApplication)
    fun inject(homeActivity: HomeActivity)
    fun inject(detailActivity: DetailActivity)

}