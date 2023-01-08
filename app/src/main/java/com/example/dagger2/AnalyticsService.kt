package com.example.dagger2

import android.util.Log


//Case 10:
interface AnalyticsService {
    fun trackEvent(eventName: String, eventType : String)
}

class MixPanel : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("naveen","MixPanel - $eventName  and $eventType")
    }
}

class FirebaseAnlytics : AnalyticsService {
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("naveen","FirebaseAnlytics - $eventName  and $eventType")
    }

}

