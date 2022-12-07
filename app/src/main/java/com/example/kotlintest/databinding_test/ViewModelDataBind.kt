package com.example.kotlintest.databinding_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelDataBind : ViewModel(){
  // with mutable live data
  val factLiveData = MutableLiveData<String>("this is live data")
    fun updateLiveData(){
      factLiveData.value = "another face"
    }


    // with live data
//  private val factLiveDataObj = MutableLiveData<String>("this is live data")
//
//    val factLiveData : LiveData<String>
//    get() = factLiveDataObj
//
//    fun updateLiveData(){
//        factLiveDataObj.value = "another face"
//    }

}