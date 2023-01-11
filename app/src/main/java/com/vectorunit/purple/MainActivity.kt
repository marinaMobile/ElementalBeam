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
import com.vectorunit.purple.policy.BeamAct
import com.vectorunit.purple.policy.RedirAct
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import io.branch.referral.Branch
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
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewMainModel by viewModel<ViMod>(named("MainModel"))
        GlobalScope.launch (Dispatchers.IO){
            viewMainModel.getData()
        }


        Branch.sessionBuilder(this).withCallback { branchUniversalObject, linkProperties, error ->
            if (error != null) {
                Log.e("BranchSDK_Tester", "branch init failed. Caused by -" + error.message)
            } else {
                Log.e("BranchSDK_Tester", "branch init complete!")
                if (branchUniversalObject != null) {
                    Log.e("BranchSDK_Tester", "title " + branchUniversalObject.title)
                    Log.e(
                        "BranchSDK_Tester",
                        "CanonicalIdentifier " + branchUniversalObject.canonicalIdentifier
                    )
                    Log.e(
                        "BranchSDK_Tester",
                        "metadata " + branchUniversalObject.contentMetadata.convertToJson()
                    )
                }
                if (linkProperties != null) {
                    Log.e("BranchSDK_Tester", "Channel " + linkProperties.channel)
                    Log.e("BranchSDK_Tester", "control params " + linkProperties.controlParams)
                }
            }
        }.withData(this.intent.data).init()
    }
    }




}