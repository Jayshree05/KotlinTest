package com.example.kotlintest.mvvm_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.mvvm_retrofit.repository.QuoteRepository


// this factory create the object of viewmodel
class QuoteViewModelFactory(private var repository: QuoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  QuoteViewModel(repository) as T
    }
}