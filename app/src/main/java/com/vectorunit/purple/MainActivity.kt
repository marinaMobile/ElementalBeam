package com.vectorunit.purple

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vectorunit.purple.MainCla.Companion.C1
import com.vectorunit.purple.MainCla.Companion.appsCheckChe
import com.vectorunit.purple.policy.RedirAct
import com.vectorunit.purple.policy.ViMod
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    lateinit var countryDev: String
    lateinit var wv: String
    lateinit var apps: String
    lateinit var country: String
    lateinit var appCamp: String
    lateinit var deepSt: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewMainModel by viewModel<ViMod>(named("MainModel"))
        GlobalScope.launch (Dispatchers.IO){
            viewMainModel.getData()
        }
    }


}