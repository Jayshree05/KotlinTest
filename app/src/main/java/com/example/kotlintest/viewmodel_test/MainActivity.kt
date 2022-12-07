package com.example.kotlintest.viewmodel_test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityDatabindBinding

// When android apk config change (like device rotation, keyboard open)
// that time our activity call onResume function and all the variable (var count=0) call
// and reset our initial position instead of current position like (count = 5)
// So store our data we need to use viewmodel


class MainActivity : AppCompatActivity() {
    var count = 0
    lateinit var binding: ActivityDatabindBinding

    lateinit var mainViewModel: MainViewModel  //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            increment() }

        setText()
    }

    // -------With view model--------
    fun increment() {
       mainViewModel.increment()
        setText()
    }

    fun setText() {
        binding.tvname.text = mainViewModel.count.toString()
    }


    // -------Without view model--------
//    fun increment() {
//        count++
//        setText(count)
//    }
//    fun setText(count: Int) {
//        binding.tvname.text = count.toString()
//    }

    override fun onResume() {
        super.onResume()
        Log.d("activity","onResume")
    }

}