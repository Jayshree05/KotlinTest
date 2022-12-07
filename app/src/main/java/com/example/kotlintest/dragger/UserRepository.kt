package com.example.kotlintest.dragger

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

//class UserRepository{
//    fun saveuser(email: String, password: String){
//        Log.e(TAG, "SAVE USER")
//    }
//}

interface UserRepository{
    fun saveuser(email: String, password: String){
    }
}

class SQLUserRepository @Inject constructor() : UserRepository{
    override fun saveuser(email: String, password: String){
        Log.e(TAG, "SAVE USER in SQL")
    }
}

class FirebaseUserRepository @Inject constructor() : UserRepository{
    override fun saveuser(email: String, password: String){
        Log.e(TAG, "SAVE USER in Firebase")
    }
}




