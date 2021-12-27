package com.test.di.modules.ViewModules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.home.viewmodel.HomeVM
import com.test.util.ViewModelKey


import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(HomeVM::class)
    internal abstract fun bindHomeVM(myHomeVM: HomeVM): ViewModel


}