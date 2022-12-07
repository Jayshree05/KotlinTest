package com.example.kotlintest.mvvm_retrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
//    http://quotable.io/quotes?page=1
    private const val baseurl = "http://quotable.io/"

    fun getRetroInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}