package com.example.kotlintest.code

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityLoginBinding
import com.example.kotlintest.databinding_test.ViewModelDataBind
import java.util.Observer

class LogInActivity : AppCompatActivity(), LogInHandler {

    private lateinit var viewModel: LogInViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding
        val binding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)

        // ViewModel
        viewModel =  ViewModelProvider(this).get(LogInViewModel::class.java)

        // Setting binding params
        binding.viewModel = viewModel
        binding.handler = this

        // Watching for login result
        viewModel.getLogInResult().observe(this,{
         Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    override fun onLogInClicked() {
        viewModel.performValidation()
    }

}




