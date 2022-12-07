package com.example.kotlintest.mvvm_dragger.module.retrofit

import com.example.kotlintest.mvvm_dragger.module.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerApi {

    @GET("products")
    suspend fun getProduct():Response<List<Product>>

}