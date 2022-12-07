package com.example.kotlintest.mvvm_dragger.module.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintest.mvvm_dragger.module.Product
import com.example.kotlintest.mvvm_dragger.module.repository.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//class MainViewModel(private val repository: ProductRepository) : ViewModel() {


    // if we have multiple classes in this viewmodel then we have to pass all classes in its constructors
//    so remove this problem we have to create object with the help of dagger

//    class MainViewModel(private val repository: ProductRepository, private val randmize: Randmize) : ViewModel() {


// we have to add inject with field contructor
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {
    val productsLiveData: LiveData<List<Product>>
        get() = repository.products

    init {
        viewModelScope.launch {
            repository.getProducts()
        }
    }
}

class Randmize @Inject constructor(){

    fun onAction(){
        Log.d("Randmize", "call class randmize")
    }
}