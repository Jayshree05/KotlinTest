package com.example.kotlintest.mvvm_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlintest.mvvm_retrofit.api.QuoteService
import com.example.kotlintest.mvvm_retrofit.model.QuoteList

class QuoteRepository(private var quoteservice: QuoteService) {

    private val quoteLiveData = MutableLiveData<QuoteList>()

    val quotes: LiveData<QuoteList>
        get() = quoteLiveData

    suspend fun getQuotes(page: Int) {
        var result = quoteservice.getQuotes(page)
//        var result = quoteservice.getFAQ()

//        var result = quoteservice.getLogin(LoginRequest(91,9691705217,"email"
//        ,"dev@gmail.com","123456",2,"12345"))
//        println("=====quotes result==============" +result.body())


        if (result?.body() != null) {
            quoteLiveData.postValue(result.body())
        }
    }

}