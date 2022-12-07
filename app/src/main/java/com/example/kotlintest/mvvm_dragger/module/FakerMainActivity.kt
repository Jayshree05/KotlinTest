package com.example.kotlintest.mvvm_dragger.module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R
import com.example.kotlintest.mvvm_dragger.module.di.FakerApplication
import com.example.kotlintest.mvvm_dragger.module.viewmodel.MainViewModel
import com.example.kotlintest.mvvm_dragger.module.viewmodel.MainViewModel2
import com.example.kotlintest.mvvm_dragger.module.viewmodel.MainViewModelFactory
import javax.inject.Inject

class FakerMainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as FakerApplication).applicationComponent.inject(this)

        mainViewModel = ViewModelProvider(this, mainViewModelFactory).get(MainViewModel::class.java)


        val map = (application as FakerApplication).applicationComponent.getMap()

        println("map")
        println(map)


        mainViewModel.productsLiveData.observe(this,{
            products.text = it.joinToString { x -> x.title +"\n\n" }
        })
    }
}