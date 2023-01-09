package com.vectorunit.purple

import android.app.Application
import com.onesignal.OneSignal
import com.vectorunit.purple.policy.util.appModule
import com.vectorunit.purple.policy.util.viewModelModule
import io.branch.referral.Branch
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class MainCla: Application() {
    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId("f38a0369-f672-4bed-af24-2a19ee3447f2")

        Branch.enableTestMode()

        // Branch object initialization
        Branch.getAutoInstance(this)

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