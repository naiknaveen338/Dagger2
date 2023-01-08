package com.example.dagger2

import android.app.Application

class UserApplication : Application() {
/*
    lateinit var userRegistrationComponent: UserRegistrationComponent
*/

    //Case 9 :
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
/*
        userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(10)
*/
        appComponent = DaggerAppComponent.builder().build()

    }
}