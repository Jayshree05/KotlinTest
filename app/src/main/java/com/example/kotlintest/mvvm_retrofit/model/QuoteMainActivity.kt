package com.example.kotlintest.mvvm_retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.databinding.ActivityRvBinding
import com.example.kotlintest.mvvm_retrofit.api.QuoteService
import com.example.kotlintest.mvvm_retrofit.api.RetrofitHelper
import com.example.kotlintest.mvvm_retrofit.model.ListResult
import com.example.kotlintest.mvvm_retrofit.model.QuoteListAdapter
import com.example.kotlintest.mvvm_retrofit.repository.QuoteRepository
import com.example.kotlintest.mvvm_retrofit.viewmodel.QuoteViewModel
import com.example.kotlintest.mvvm_retrofit.viewmodel.QuoteViewModelFactory


class QuoteMainActivity : AppCompatActivity() {
    lateinit var quoteViewModel: QuoteViewModel
    private lateinit var binding: ActivityRvBinding
    private lateinit var quoteList: List<ListResult>
    private var pageNum = 1
    var isLoading = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, com.example.kotlintest.R.layout.activity_rv)

        val quoteService = RetrofitHelper.getRetroInstance().create(QuoteService::class.java)
        val repository = QuoteRepository(quoteService)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvcontent.layoutManager = layoutManager
        binding.rvcontent.itemAnimator = DefaultItemAnimator()

        quoteViewModel = ViewModelProvider(this, QuoteViewModelFactory(repository)).get(QuoteViewModel::class.java)

        quoteViewModel.quotes.observe(this,{
            quoteList =  it.results
            setAdapter(quoteList)
            isLoading = false
        })


        binding.rvcontent.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleItemCount = layoutManager.childCount
                val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                val total = QuoteListAdapter(quoteList).itemCount

                if (!isLoading) {
                    if ((visibleItemCount + pastVisibleItem) >= total) {
                        pageNum++
                        println(pageNum)
//                        repository.getQuotes(pageNum)
                        isLoading = true
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })


    }


    fun setAdapter(results: List<ListResult>) {
        val adapter = QuoteListAdapter(results)
        binding.rvcontent.adapter = adapter
    }

}