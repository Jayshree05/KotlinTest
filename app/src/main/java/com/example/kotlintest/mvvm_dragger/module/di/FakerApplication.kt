package com.example.kotlintest.mvvm_dragger.module.di

import android.app.Application
import dagger.Component

class FakerApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder().build()

    }
}