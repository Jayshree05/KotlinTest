package com.example.kotlintest.mvvm_dragger.module.di

import androidx.lifecycle.ViewModel
import com.example.kotlintest.mvvm_dragger.module.retrofit.FakerApi
import com.example.kotlintest.mvvm_dragger.module.utils.Constants
import com.example.kotlintest.mvvm_dragger.module.viewmodel.MainViewModel
import com.example.kotlintest.mvvm_dragger.module.viewmodel.MainViewModel2
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class ViewModelModule {

    @Binds
//    @ClassKey(MainViewModel::class)
    @StringKey("mainViewModel")
    @IntoMap  // this is the like distionary & use their value in the form of key value pair
    abstract fun mainviewmodel(mainViewModel: MainViewModel) : ViewModel

    @Binds
//    @ClassKey(MainViewModel2::class)
    @StringKey("mainViewModel2")
    @IntoMap
    abstract fun mainviewmodel2(mainViewModel2: MainViewModel2) : ViewModel
}