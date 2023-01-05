package com.vectorunit.purple.secondgame

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import com.vectorunit.purple.databinding.ActivityBonusSecGameBinding
import java.util.*
import kotlin.collections.ArrayList

class BonusSecGame : AppCompatActivity() {
    var qposldkxmc: Runnable = Runnable { }


    private var osdjsdi : CountDownTimer? = null

    private lateinit var cdisodp: ActivityBonusSecGameBinding
    var usdjijixczji: Int = 0

    var rtysd: Handler = Handler(Looper.getMainLooper())

    var etsydu = ArrayList<ImageView>()

    private lateinit var winCurrent : SharedPreferences

    private var intCurrent = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cdisodp = ActivityBonusSecGameBinding.inflate(layoutInflater)
        setContentView(cdisodp.root)

        winCurrent = getSharedPreferences("winEl", MODE_PRIVATE)
        intCurrent = winCurrent.getInt("winEl",0)


        hideShow()

        usdjijixczji = 0
        cdisodp.rodisdf.text = "0"






        cdisodp.eosp.setOnClickListener {
            epold()
        }

        cdisodp.aposldkasd.setOnClickListener {
            epold()
        }
        cdisodp.trts.setOnClickListener {
            epold()
        }
        cdisodp.dcgf.setOnClickListener {
            epold()
        }
        cdisodp.podll.setOnClickListener {
            epold()
        }




        etsydu = arrayListOf(
            cdisodp.trts,
            cdisodp.dcgf,
            cdisodp.eosp,
            cdisodp.aposldkasd,
            cdisodp.podll,
            cdisodp.udiwqdo,

            )
    }


    private fun hideShow() = with(cdisodp){
        imMag.setOnClickListener {
            text1.visibility = View.GONE
            text2.visibility = View.GONE
            text3.visibility = View.GONE
            imMag.visibility = View.GONE
            gridLayout.visibility = View.VISIBLE
            usdai.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            card.visibility = View.VISIBLE
            tvTimer.visibility = View.VISIBLE
            wopslxm()
            friosdpsp()
        }
    }


    @SuppressLint("SetTextI18n")
    fun friosdpsp() {
        usdjijixczji = 0
        cdisodp.rodisdf.text = "Catched : $usdjijixczji"
        wopslxm()
        cdisodp.usdai.text = "Time : " + 15000 / 1000

        for (gio in etsydu) {
            gio.visibility = View.INVISIBLE
        }

        osdjsdi = object : CountDownTimer(10000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onFinish() {
                cdisodp.usdai.text = "Time's up!!!"
                rtysd.removeCallbacks(qposldkxmc)
                DialogScreen.showdialog(this@BonusSecGame,intCurrent,usdjijixczji)

            }

            @SuppressLint("SetTextI18n")
            override fun onTick(p0: Long) {
                cdisodp.usdai.text = "Time : " + p0 / 1000
            }
        }.start()
    }




    @SuppressLint("SetTextI18n")
    fun epold() {
        usdjijixczji++
        cdisodp.rodisdf.text = "Catched : $usdjijixczji"
    }

    private fun wopslxm() {
        qposldkxmc = Runnable {
            for (rasdfasdgasdgshad in etsydu) {
                rasdfasdgasdgshad.visibility = View.INVISIBLE
            }
            val gudi = Random()
            val sdpf = gudi.nextInt(5 - 0)
            etsydu[sdpf].visibility = View.VISIBLE
            rtysd.postDelayed(qposldkxmc, 400)
        }
        rtysd.post(qposldkxmc)
    }


    override fun onDestroy() {
        super.onDestroy()
        osdjsdi?.cancel()
    }
}