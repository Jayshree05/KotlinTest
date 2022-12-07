package com.example.kotlintest

import android.app.Application
import com.example.kotlintest.dragger.UserRegistrationComponent
import com.example.kotlintest.dragger.UserRegistrationService
import javax.inject.Inject

class MainApplication: Application() {
//    @Inject
//    public lateinit var userRegistrationService: UserRegistrationService

   override fun onCreate() {
        super.onCreate()
//       userRegistrationService = DaggerUserRegistrationComponent.factory().create(5)
   }
}
