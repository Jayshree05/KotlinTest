package com.example.kotlintest.dragger

import android.content.ContentValues.TAG
import android.util.Log
import com.example.daggermvvm.testing.MessageQualifier
import javax.inject.Inject
import javax.inject.Singleton

//class EmailService {
//    fun send(to: String, from: String, body: String){
//        Log.e(TAG, "SEND EMAIL to user")
//    }
//}

//class EmailService @Inject constructor() {
//    fun send(to: String, from: String, body: String){
//        Log.e(TAG, "SEND EMAIL to user")
//    }
//}

interface NotificationService{
    fun send(to: String, from: String, body: String){
    }
}

class EmailService @Inject constructor() :NotificationService {
    override fun send(to: String, from: String, body: String){
        Log.e(TAG, "SAVE SEND EMAIL")
    }
}

class MessageService(private val count: Int) :NotificationService {
    override fun send(to: String, from: String, body: String){
        Log.e(TAG, "SAVE SEND Message $count")
    }
}