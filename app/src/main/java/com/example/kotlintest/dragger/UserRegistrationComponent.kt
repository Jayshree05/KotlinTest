package com.example.kotlintest.dragger

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

// component -> Dagger return the object which i required

@Component(modules = [UserRepositoryModule::class,NotificationServiceModule::class])

//@Component
interface UserRegistrationComponent {

//    fun getUserRegistrationService(): UserRegistrationService
//    fun getEmailService(): EmailService

    fun inject(mainActivity: MainActivity)  // for filed injection


    @Component.Factory
    interface Factory{
fun create(@BindsInstance count: Int) :UserRegistrationComponent
    }

}