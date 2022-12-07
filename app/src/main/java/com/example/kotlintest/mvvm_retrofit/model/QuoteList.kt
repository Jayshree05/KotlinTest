package com.example.kotlintest.mvvm_retrofit.model


data class QuoteList(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<ListResult>,
    val totalCount: Int,
    val totalPages: Int
)