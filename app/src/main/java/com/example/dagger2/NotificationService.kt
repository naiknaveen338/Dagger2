package com.example.dagger2

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

//Case 3 :
interface NotificationService {
    fun send(email: String, s: String, s1: String)
}

//Single Object of this

//We can use this customscope which exactly behaves likess @Singleton
//@ApplicationScope
@ActivityScope
class MessageService @Inject constructor() : NotificationService{
    override fun send(email: String, s: String, s1: String) {
        Log.w("naveen","Messgae Sent")
    }
}

class EmailService(private val retryCOunt : Int) : NotificationService{
    override fun send(email: String, s: String, s1: String) {
        Log.w("naveen","EMail Sent retryCount : $retryCOunt")
    }
}
