package com.example.dagger2

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AnalyticsModule::class])
interface AppComponent {
    //Removed this as a part of case 11
    //fun getAnalyticsService() : AnalyticsService


    //Add Subcomponent here , In ourcase its UserRegistrationComponent so added this
    //fun getUserRegistrationComponent() : UserRegistrationComponent.Factory

    //Case 12
    fun getUserRegistrationBuilder() : UserRegistrationComponent.Builder
}