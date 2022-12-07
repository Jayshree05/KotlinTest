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

class MainViewModel2 @Inject constructor(private val randmize: Randmize) : ViewModel() {

      init {
            randmize.onAction()
    }
}
