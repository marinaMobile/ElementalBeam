package com.vectorunit.purple.policy

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData

class ViMod(val application: Application): ViewModel() {

    fun convers(cont: Context) {
        AppsFlyerLib.getInstance()
            .init("", conversionDataListener, application)
        AppsFlyerLib.getInstance().start(cont)
    }
    fun fbDeee(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
            }
        }
    }

    private val conversionDataListener  = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {

        }
        override fun onConversionDataFail(error: String?) {
        }
        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {

        }
        override fun onAttributionFailure(error: String?) {
        }
    }
}