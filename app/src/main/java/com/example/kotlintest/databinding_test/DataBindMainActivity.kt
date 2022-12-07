package com.example.kotlintest.databinding_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlintest.R
import com.example.kotlintest.databinding.ActivityDatabindBinding

class DataBindMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityDatabindBinding
    lateinit var mainviewmodel : ViewModelDataBind

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_databind)
//      setContentView(R.layout.activity_databind)  // normal code without binding


        // Data bindind  we use 1 data class(model) which contains name of the user
//       val userObj = User("hello")
//        binding.user = userObj

//        binding.tvname.text = "hello" // with binding

        // normal code without binding
//var name = findViewById<TextView>(R.id.tvname)
//    name.text = "hello"


//        ======= live data=====
        mainviewmodel =  ViewModelProvider(this).get(ViewModelDataBind::class.java)

        // normal text set on textview
//        mainviewmodel.factLiveData.observe(this,{
//            binding.tvname.text = it
//        })

        // normal button click
//        binding.btnLogin.setOnClickListener{
//            mainviewmodel.updateLiveData()
//        }


        // data binding with viewmodel -
// 1. need to inform our binding object to our viewmodel class that we use this viewmodel class to our xml
//  2. need to inform our binding object to our textview in xml -> that textview updated with our live data
//       but here is the owner object(this) with our live data so we need to bind with our owner(current atctivity)
//        with this binding

//        3. edit text bind with two way live data in xml with (=) symbol -> "@={mainviewmodel.factLiveData}"
          binding.mainviewmodel = mainviewmodel
          binding.lifecycleOwner = this

    }

}