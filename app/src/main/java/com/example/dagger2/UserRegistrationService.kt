package com.example.dagger2

import javax.inject.Inject
import javax.inject.Named

class UserRegistrationService @Inject constructor(
    //We need to use @Named here , coz in NotificationModule there are 2 methods which returns NotificationService
    //To distinguish that we need to use this
    //THis is commented
    //@Named("email")val notificationService: NotificationService,


    //Here MessageQualifier, tells dagger where this qualifier is used , take that object
    //It is used in NotificationModule for getEmailService
    @MessageQualifier val notificationService: NotificationService,
    val repository: UserRepository
) {

    fun registerUser(email: String, password : String) {
        repository.saveUserEmail(email, password)
        notificationService.send(email, "asdas@gmail.com","User Regsitered")
    }
}