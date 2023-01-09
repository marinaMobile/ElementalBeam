package com.vectorunit.purple

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.vectorunit.purple.policy.BeamAct
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import io.branch.referral.Branch
import com.vectorunit.purple.policy.ViMod
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named



class MainActivity : AppCompatActivity() {
    val shareP: SharedPreferences by inject(named("SharedPreferences"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val viewMainModel by viewModel<ViMod>(named("MainModel"))

        startActivity(Intent(this, BeamAct::class.java))

        viewMainModel.convers(this@MainActivity)

        viewMainModel.fbDeee(this@MainActivity)

        Branch.sessionBuilder(this).withCallback { branchUniversalObject, linkProperties, error ->
            if (error != null) {
                Log.e("BranchSDK_Tester", "branch init failed. Caused by -" + error.message)
            } else {
                Log.e("BranchSDK_Tester", "branch init complete!")
                if (branchUniversalObject != null) {
                    Log.e("BranchSDK_Tester", "title " + branchUniversalObject.title)
                    Log.e("BranchSDK_Tester", "CanonicalIdentifier " + branchUniversalObject.canonicalIdentifier)
                    Log.e("BranchSDK_Tester", "metadata " + branchUniversalObject.contentMetadata.convertToJson())
                }
                if (linkProperties != null) {
                    Log.e("BranchSDK_Tester", "Channel " + linkProperties.channel)
                    Log.e("BranchSDK_Tester", "control params " + linkProperties.controlParams)
                }
            }
        }.withData(this.intent.data).init()


    }
    fun checkAppps() {
        val executorService = Executors.newSingleThreadScheduledExecutor()
        val exr = Executors.newSingleThreadScheduledExecutor()
        var appsChe = shareP.getString(appsCheckChe, null)
        var appsCamp = shareP.getString(C1, null)

        exr.scheduleAtFixedRate({
            if (appsChe != null) {
                Log.d("appsChec", "checkAppps:$appsChe ")
                exr.shutdownNow()
                when (appsChe) {
                    "1" ->
                        executorService.scheduleAtFixedRate({
                            if (appsCamp != null) {
                                executorService.shutdownNow()
                                nextAct()
                            } else {
                                appsCamp = shareP.getString(C1, null)
                            }
                        }, 0, 1, TimeUnit.SECONDS)
                    else ->
                        nextAct()
                }
            } else {
                Log.d("appsChec", "checkAppps:$appsChe ")
                appsChe = shareP.getString(appsCheckChe, null)
            }
        }, 0, 1, TimeUnit.SECONDS)
    }

    fun nextAct() {
        val intentNext = Intent(this@MainActivity, FillAct::class.java)
        startActivity(intentNext)
        finish()
    }
}