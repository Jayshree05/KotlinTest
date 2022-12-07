package com.example.kotlintest.mvvm_retrofit.api

import com.example.kotlintest.mvvm_retrofit.model.QuoteList
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface QuoteService {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<QuoteList>

//    @GET("faq")
//    suspend fun getFAQ()
//
//    @POST("Login")
//    suspend fun getLogin(@Body loginRequest: LoginRequest) : Response<JsonObject>
//

}