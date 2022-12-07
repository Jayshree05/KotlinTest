package com.example.kotlintest.dragger


import com.example.daggermvvm.testing.MessageQualifier
import javax.inject.Inject
import javax.inject.Named


//class UserRegistrationService () {
//val userRepository = UserRepository()
//val emailService = EmailService()
//    fun registerUser(email: String, password: String){
//        userRepository.saveuser(email,password)
//        emailService.send(email,"xyz@gmail.com", "User register")
//    }
//}

//class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
//                              private val emailService: EmailService) {
//    fun registerUser(email: String, password: String){
//        userRepository.saveuser(email,password)
//        emailService.send(email,"xyz@gmail.com", "User register")
//    }
//}


// in this class only email service call that means its tightly coupled with email service to resollve this
//we need change its email sevice class.

// Now user can send notification via email or msg, only userregisterservice call send methode,
// the background implementaion of "send" methode class dont know, now its loosly coupled
/*
class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
                                                  private val notificationService: NotificationService) {

    fun registerUser(email: String, password: String){
        userRepository.saveuser(email,password)
        notificationService.send(email,"xyz@gmail.com", "User register")
    }*/


    /*class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
                                                     @Named("message") private val notificationService: NotificationService) {

        fun registerUser(email: String, password: String){
            userRepository.saveuser(email,password)
            notificationService.send(email,"xyz@gmail.com", "User register")
        }
    }
*/

    class UserRegistrationService @Inject constructor(private val userRepository: UserRepository,
                                                @MessageQualifier  private val notificationService: NotificationService) {

    fun registerUser(email: String, password: String){
        userRepository.saveuser(email,password)
        notificationService.send(email,"xyz@gmail.com", "User register")
    }
    }


