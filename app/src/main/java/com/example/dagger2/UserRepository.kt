package com.example.dagger2

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository {
    fun saveUserEmail(email: String, password: String)

}

@ActivityScope
class SQLRepository @Inject constructor(val analyticsService: AnalyticsService) : UserRepository{
    override fun saveUserEmail(email: String, password: String) {
        Log.w("naveen","User saved in DB")
        analyticsService.trackEvent("Save user", "CREATE")
    }
}

class FireBaseRepository(val analyticsService: AnalyticsService): UserRepository {
    override fun saveUserEmail(email: String, password: String) {
        Log.w("naveen","User saved in Firebase")
        analyticsService.trackEvent("Save User","Update")
    }

}