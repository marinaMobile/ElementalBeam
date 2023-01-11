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
import io.branch.referral.util.BRANCH_STANDARD_EVENT
import io.branch.referral.util.BranchEvent
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named

class RedirAct : AppCompatActivity() {
    val shareP: SharedPreferences by inject(named("SharedPreferences"))
    lateinit var dep: String
    lateinit var camp: String
    lateinit var che: String
    lateinit var code: String
    lateinit var cou: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redir)

        getSharedData()

        BranchEvent(BRANCH_STANDARD_EVENT.VIEW_ITEM).setDescription("NoChannelButFromRedirect").logEvent(this@RedirAct)
        Log.d("Branch Check", "I'm here in REDIRACT, branch bitch! No source though")

    }

    fun getSharedData() {

        dep = shareP.getString(deepL, null).toString()
        camp = shareP.getString(C1, null).toString()
        che = shareP.getString(appsCheckChe, null).toString()
        code = shareP.getString(geoCo, null).toString()
        cou = shareP.getString(codeCode, null).toString()

        sort()
    }

    fun sort() {
        val intentNorm = Intent(this@RedirAct, BeamAct::class.java)

        if(che=="1") {
            if(camp.contains("tdb2")&&dep.contains("tdb2")) {
                intentNorm.putExtra("WebInt", "campaign")
                startActivity(intentNorm)
                finish()
            } else if (camp.contains("tdb2")|| code.contains(cou)) {
                intentNorm.putExtra("WebInt", "campaign")
                startActivity(intentNorm)
                finish()
            } else if (dep.contains("tdb2") && !camp.contains("tdb2")) {
                intentNorm.putExtra("WebInt", "deepLink")
                startActivity(intentNorm)
                finish()
            }
            else {
                startActivity(Intent(this, FirstAct::class.java))
                finish()
            }
        } else {
            if (dep.contains("tdb2")) {
                intentNorm.putExtra("WebInt", "deepLink")
                startActivity(intentNorm)
                finish()
            } else if(code.contains(cou)) {
                intentNorm.putExtra("WebInt", "MT")
                startActivity(intentNorm)
                finish()
            } else {
                startActivity(Intent(this, FirstAct::class.java))
                finish()
            }
        }
    }
}