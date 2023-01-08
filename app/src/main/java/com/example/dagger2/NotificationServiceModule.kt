package com.example.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Named

//Here in this we might need to return NotificationService twice, depending on Runtime .
//FOr this we need to use @Named annotation
@Module
//Case III
/*class NotificationServiceModule constructor(private val retryCount : Int) {*/
//Case IV
class NotificationServiceModule {
    @ActivityScope
    @MessageQualifier
    /*@Named("email")*/
    @Provides
    //We added here retryCount coz. of Case IV
    fun getEmailService(retryCount: Int) : NotificationService {
        return EmailService(retryCount)
    }

    @ActivityScope
    @Named("message")
    @Provides
    fun bindMessageService(messageService: MessageService) : NotificationService {
        return messageService
    }

}