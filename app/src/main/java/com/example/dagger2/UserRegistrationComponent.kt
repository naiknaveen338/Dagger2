package com.example.dagger2

import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@ActivityScope
//Removed @Componenet and Added @SubComponent as a part of case 11.
@Subcomponent(/*  commented this for case 11,  case 10 : *//*dependencies = [AppComponent::class]*/ modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserRegistrationComponent {
    //Case 1 : Constructor Injection
    //Here we are returing UserRegistrationService for DaggerUserRegistrationComponent in Main Activity
    //Commented
    /*fun getUserRegistrationService() : UserRegistrationService
    //If we want EmailService in MainActvity also , Then add below
    fun getEmailService() : EmailService*/

    //Case 2 : Field Injection
    fun inject(mainActivity: MainActivity)


    //Case iV :
    //With this approach , wheneever UserRegistrationComponent gets ready , it will be having valur of retryCount as well
    //@Component.Factory
    //This is added as a part of case 11:
   /* @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance retryCount : Int, *//*Commented this for case 11 ,  This is added as a part of Case 10 :*//**//* appComponent: AppComponent*//*) : UserRegistrationComponent
    }*/



    //Case 12 : Builder
    @Subcomponent.Builder
    interface Builder {
        fun build() : UserRegistrationComponent
        fun retryCount(@BindsInstance retryCount: Int) : Builder
    }


}