package com.example.kotlintest.mvvm_retrofit.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintest.databinding.QuotelistDataBinding

class QuoteListAdapter(private val largeNewsList: List<ListResult>) : RecyclerView.Adapter<QuoteListAdapter.LargeNewsViewHolder>() {

    private lateinit var binding: QuotelistDataBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LargeNewsViewHolder {
        binding = QuotelistDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LargeNewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LargeNewsViewHolder, position: Int) {
        val largeNews = largeNewsList[position]
        println(largeNews)
        holder.bind(largeNews)
    }

    override fun getItemCount(): Int = largeNewsList.size

    class LargeNewsViewHolder(
        private val binding: QuotelistDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(largeNews: ListResult) {
            binding.result = largeNews
        }
    }
}
