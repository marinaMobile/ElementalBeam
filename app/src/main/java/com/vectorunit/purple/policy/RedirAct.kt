package com.vectorunit.purple.policy

import android.content.Context
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
import com.vectorunit.purple.databinding.ActivityRedirBinding
import com.vectorunit.purple.firstgame.FirstAct
import com.vectorunit.purple.secondgame.SecondAct
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class RedirAct : AppCompatActivity() {

    lateinit var bindRedit: ActivityRedirBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindRedit = ActivityRedirBinding.inflate(layoutInflater)
        setContentView(bindRedit.root)

        bindRedit.firstBtn.setOnClickListener {
            startActivity(Intent(this, FirstAct::class.java))
        }
        bindRedit.secBtn.setOnClickListener {
            startActivity(Intent(this, SecondAct::class.java))
        }

        bindRedit.polBtn.setOnClickListener {

            val linjOne = "https://www.terms"
            val linjTwo = "feed.com/live/"
            val linjThree = "e3ace1a4-0a30-49f2-b44b-25c51060cc1c"
            val lll = "$linjOne$linjTwo$linjThree"

            val shar = getSharedPreferences("SHARED_PREF",
                Context.MODE_PRIVATE)
            shar.edit().putString("link", lll).apply()
            shar.edit().putString("WebInt", "policy").apply()
            val intn = Intent(this, BeamAct::class.java)
            startActivity(intn)
        }
    }

}