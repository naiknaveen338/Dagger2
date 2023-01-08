package com.example.dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    //Case 2 : Field injection
    @Inject
    lateinit var userRegistrationService: UserRegistrationService

    lateinit var userRegistrationService1: UserRegistrationService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val us = UserRegistrationService()
        //Case 1 : Create a individual method for Each dependency required foir MainActivity in Component
        //commented
        /*val userRegistrationService = DaggerUserRegistrationComponent.builder().build().getUserRegistrationService()
        userRegistrationService.registerUser("naik@gmail.com","23232")*/


        //Case 2 : Here we just inject this to component, so that we can get the reference of any object from component
       // val component  = DaggerUserRegistrationComponent.builder().build()
        // component.inject(this)
        //userRegistrationService.registerUser("ndn@gmail.com","122323")



        //This is Activity level component
        //BindInstance Factory:
     /*   val component  = DaggerUserRegistrationComponent.factory().create(4)
        component.inject(this)
        userRegistrationService.registerUser("naveen@gmail.com","21212")*/

        //Application level component
        //Here userRegistrationComponent created in UserApplication class
        //So in this component singleton obvject will live as long as UserApplication class lives
      /*  val component = (application as UserApplication).userRegistrationComponent
        component.inject(this)
        userRegistrationService.registerUser("naveen@gmail.com","21212")*/

        //Case 10 :
    /*    val appComponent = (application as UserApplication).appComponent
        val userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(4,appComponent)
        userRegistrationComponent.inject(this)
        */



        //case 11: Subcomponent
      /*  val appComponent = (application as UserApplication).appComponent
        appComponent.getUserRegistrationComponent().create(3).inject(this)
        userRegistrationService.registerUser("naik2@gmail.com","1234")*/


        //case 12 : Buildr
        val appComponent = (application as UserApplication).appComponent
        appComponent.getUserRegistrationBuilder().retryCount(2).build().inject(this)
        userRegistrationService.registerUser("naik2@gmail.com","1234")
    }
}