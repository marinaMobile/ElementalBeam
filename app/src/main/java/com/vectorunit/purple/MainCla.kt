package com.vectorunit.purple

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.vectorunit.purple.policy.util.appModule
import com.vectorunit.purple.policy.util.viewModelModule
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level
import java.util.*

class MainCla: Application() {

    companion object {
        const val ONESIGNAL_APP_ID = "f38a0369-f672-4bed-af24-2a19ee3447f2"
        val myId: String = "myID"
        var instId: String? = "instID"
        var urlMain: String = "link"
        var MAIN_ID: String? = "main_id"
        var aps_id: String? = "main_id"
        var C1: String? = "c11"
        const val myTrId = ""
        val appsCheckChe: String = "appsCheckChe"
        val geoCo: String = "geoCo"
        //        val userCo: String = "userCo"
        val codeCode: String = "uff"
        val deepL: String = "deepL"
        var AIR_BALANCE = 500
        var defaultValue = "null"
    }

    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        Branch.enableTestMode()

        // Branch object initialization
        Branch.getAutoInstance(this)



        val shP = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val settings = getSharedPreferences("PREFS_NAME", 0)

        val trackerParams = MyTracker.getTrackerParams()
        val trackerConfig = MyTracker.getTrackerConfig()
        val instID = MyTracker.getInstanceId(this)
        trackerConfig.isTrackingLaunchEnabled = true
        val IDIN = UUID.randomUUID().toString()

        if (settings.getBoolean("my_first_time", true)) {
            trackerParams.setCustomUserId(IDIN)
            shP.edit().putString(myId, IDIN).apply()
            shP.edit().putString(instId, instID).apply()
            settings.edit().putBoolean("my_first_time", false).apply()
        } else {
            val shIDIN = shP.getString(myId, IDIN)
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