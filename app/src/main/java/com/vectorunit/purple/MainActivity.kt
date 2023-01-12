package com.vectorunit.purple

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vectorunit.purple.policy.ViMod
import io.branch.referral.Branch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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