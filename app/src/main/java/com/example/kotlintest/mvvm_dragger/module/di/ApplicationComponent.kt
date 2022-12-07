package com.example.kotlintest.mvvm_dragger.module.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.kotlintest.mvvm_dragger.module.FakerMainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class,ViewModelModule::class])
//@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(fakerMainActivity: FakerMainActivity)
    fun getMap() : Map<String, ViewModel>

//        fun getMap() : Map<Class<*>, ViewModel>

}