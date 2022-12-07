package com.example.kotlintest.dragger

import com.example.daggermvvm.testing.MessageQualifier
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class NotificationServiceModule() {
//    class NotificationServiceModule (private val count: Int){   // pass value dynamic without factory from module parameter

    /*  @Provides
      fun getMessageService() : NotificationService{
          return MessageService()
      }

      @Provides
      fun getEmailService(emailService: EmailService) : NotificationService{
          return emailService
      }*/


//   we have 2 service email & msg & both are return notification service object, so its confusion to dagger which service object dagger should create in "UserRegistrationService", so resolved this problem
//    we use @named annotation
    /* @Named("message")
      @Provides
fun getMessageService() : NotificationService{
    return MessageService()
}

    @Named("email")
@Provides
fun getEmailService(emailService: EmailService) : NotificationService{
    return emailService
}*/


    /* @MessageQualifier()
     @Provides
     fun getMessageService() : NotificationService{
         return MessageService()
     }*/


    // Pass the runtime value we can create parameterize constructor od notificationServiceModule
    // & retun messageservice object
    // pass value dynamic without factory
   /* @MessageQualifier()
    @Provides
    fun getMessageService(): NotificationService {
        return MessageService(count)
    }*/


    @MessageQualifier()
    @Provides
    fun getMessageService(count: Int): NotificationService {
        return MessageService(count)
    }

}