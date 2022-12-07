package com.example.kotlintest.mvvm_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlintest.mvvm_retrofit.api.QuoteService
import com.example.kotlintest.mvvm_retrofit.model.QuoteList
import com.example.kotlintest.mvvm_retrofit.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// bcoz we can't create viewmodel obj, so we use factory to return the obj of viewmodel
class QuoteViewModel(private var repository: QuoteRepository): ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            repository.getQuotes(1)
        }
    }

    val quotes: LiveData<QuoteList>
        get() = repository.quotes
}