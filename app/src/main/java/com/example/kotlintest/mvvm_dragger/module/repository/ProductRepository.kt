package com.example.kotlintest.mvvm_dragger.module.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlintest.mvvm_dragger.module.Product
import com.example.kotlintest.mvvm_dragger.module.retrofit.FakerApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerApi) {

    private val _products = MutableLiveData<List<Product>>()  // mutable live data is not publically accessible
    val products: LiveData<List<Product>> // only readonly so no one can change from outside
    get() = _products

    suspend fun getProducts(){
        val result = fakerApi.getProduct()
        if(result.isSuccessful && result.body() !=null){
            _products.postValue(result.body())
        }
    }

}