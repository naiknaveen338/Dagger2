package com.example.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
 abstract class UserRepositoryModule {
  //Commented : Method 1
/*
  @Provides
    fun getFireBaseRepository(analyticsService: AnalyticsService) : UserRepository {
        return FireBaseRepository(analyticsService)
    }
*/


    //Method 2 : commented
    //Here we are jus returing sqlRepository coz. SqlRepository class is constructor injected ,
    //SO Dagger knows how to create its object , so it wil create it and return
   /* @Provides
    fun getSqlRepository(sqlRepository: SQLRepository) : UserRepository {
        return sqlRepository
    }*/


    //Method 3
    //So Here we can follow this @Binds approach , when dagger knows how to create a object of  abstract method parameter ,
    //Then it will create it i.e SQLRepository and return it.
    //If Dagger doesnt know how to create SQLRepository object here i.e if SQLRepository is interface or not constructor injetced
    //Then we cant use this approach, we need to use @Provides
    @ActivityScope
    @Binds
    abstract fun bindSqlRepository(sqlRepository: SQLRepository) : UserRepository


}