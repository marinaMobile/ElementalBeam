package com.vectorunit.purple.policy

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.vectorunit.purple.MainCla.Companion.MAIN_ID
import com.vectorunit.purple.policy.util.CountryCodeJS
import com.vectorunit.purple.policy.util.CountryRepo
import com.vectorunit.purple.policy.util.DevRepo
import com.vectorunit.purple.policy.util.GeoDev
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ViMod(private val mainRepository: CountryRepo, private val devRepo: DevRepo, private val shP: SharedPreferences, val application: Application): ViewModel() {

    init {
        viewModelScope.launch (Dispatchers.IO){
            getAdvertisingIdClient()
        }
        viewModelScope.launch (Dispatchers.Main){
            getData()
        }
    }


    private val _data = MutableLiveData<CountryCodeJS>()
    val data: LiveData<CountryCodeJS>
        get() = _data


    private val _countryCode = MutableLiveData<CountryCodeJS>()
    val countryCode: LiveData<CountryCodeJS>
        get() = _countryCode

    private val _geo = MutableLiveData<GeoDev>()
    val geo: LiveData<GeoDev>
        get() = _geo


    private val _appsData = MutableLiveData<String>()
    val appsData: LiveData<String>
        get() = _appsData

    private val _deepS = MutableLiveData<String>()
    val deepS: LiveData<String>
        get() = _deepS


    private val _mainId = MutableLiveData<String?>()
    val mainId: LiveData<String?>
        get() = _mainId

    suspend fun getData() {
        _countryCode.postValue(mainRepository.getDat().body())
        getDevData()
    }

    suspend fun getDevData() {
        _geo.postValue(devRepo.getDataDev().body())
    }

    fun convers(cont: Context) {
        AppsFlyerLib.getInstance()
            .init("FYGucjvu3tc2ThYshUwBj8", conversionDataListener, application)
        AppsFlyerLib.getInstance().start(cont)
    }

    fun fbDeee(cont: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            cont
        ) { data: AppLinkData? ->
            data?.let {
                val deepData = data.targetUri?.host.toString()
                shP.edit().putString("deepSt", deepData).apply()
                Toast.makeText(cont, deepData, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val conversionDataListener  = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("media_source").toString()
            _appsData.postValue(dataGotten)
        }
        override fun onConversionDataFail(error: String?) {
        }
        override fun onAppOpenAttribution(data: MutableMap<String, String>?) {

        }
        override fun onAttributionFailure(error: String?) {
        }
    }

    fun getAdvertisingIdClient() {
        val advertisingIdClient = AdvertisingIdClient(application)
        advertisingIdClient.start()
        val idUserAdvertising = advertisingIdClient.info.id.toString()
        Log.d("AdvertId", idUserAdvertising)
        _mainId.postValue(idUserAdvertising)
    }

}