package com.vectorunit.purple

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.vectorunit.purple.policy.util.appModule
import com.vectorunit.purple.policy.util.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class MainCla: Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("f38a0369-f672-4bed-af24-2a19ee3447f2")

        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (settings.getBoolean("my_first_time", true)) {
            trackerParams.setCustomUserId(IDIN)
            shP.edit().putString("myId", IDIN).apply()
            shP.edit().putString("instId", instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()

        } else {
            val shIDIN = shP.getString("myId", IDIN)
            trackerParams.setCustomUserId(shIDIN)
        }
        MyTracker.initTracker("88792592140372975184", this)

        GlobalContext.startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MainCla)
            modules(
                listOf(
                    viewModelModule, appModule
                )
            )
        }
    }
}