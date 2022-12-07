package com.example.kotlintest.mvvm_dragger.module.di

import com.example.kotlintest.mvvm_dragger.module.retrofit.FakerApi
import com.example.kotlintest.mvvm_dragger.module.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideFakerApi(retrofit: Retrofit) : FakerApi{
        return retrofit.create(FakerApi::class.java)
    }
}