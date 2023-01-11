package com.vectorunit.purple.policy

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vectorunit.purple.MainCla.Companion.C1
import com.vectorunit.purple.MainCla.Companion.appsCheckChe
import com.vectorunit.purple.MainCla.Companion.codeCode
import com.vectorunit.purple.MainCla.Companion.deepL
import com.vectorunit.purple.MainCla.Companion.geoCo
import com.vectorunit.purple.R
import com.vectorunit.purple.firstgame.FirstAct
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class RedirAct : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redir)
    }

}