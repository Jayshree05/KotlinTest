package com.example.kotlintest.dragger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlintest.MainApplication
import com.example.kotlintest.R
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


    // field injection
    @Inject
    public lateinit var userRegistrationService: UserRegistrationService


    // Singleton
    @Inject
    public lateinit var emailService: EmailService

    @Inject
    public lateinit var emailService1: EmailService
    //

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//    ---no need to create object, we use dagger to create object with the help of component
//        val userRepository = UserRepository()
//        val emailService = EmailService()
//        val userRegistrationService = UserRegistrationService(userRepository, emailService) // constructor injection


        // --- use dagger to create the "userregistrationservice" class object
      /*  val component = DaggerUserRegistrationComponent.builder().build()
        val userRegistrationService = component.getUserRegistrationService()
        val emailService = component.getEmailService()
        userRegistrationService.registerUser("john@gmail.com", "12345")*/


        // suppose if we have 15 class like "userregistrationservice" then we have to make 15 objects of that class
//        so remove this unneccesary code we used "filed injection" & inject main class in dragger component

        // field injection
      /*  val component = DaggerUserRegistrationComponent.builder().build()
        component.inject(this)
        userRegistrationService.registerUser("john@gmail.com", "12345")
*/

        // when we pass value from dynamic in notificationServiceModule
    /*    val component = DaggerUserRegistrationComponent.builder()
            .notificationServiceModule(NotificationServiceModule(3))
            .build()
        component.inject(this)
        userRegistrationService.registerUser("john@gmail.com", "12345")*/


        // when we pass value from dynamic from factory methode
            val component = DaggerUserRegistrationComponent.factory().create(5)
            component.inject(this)
            userRegistrationService.registerUser("john@gmail.com", "12345")


        // pass singleton with application level
//        val component = (application as MainApplication).userRegistrationService
//        component.inject(this)
//        userRegistrationService.registerUser("john@gmail.com", "12345")

    }


}

