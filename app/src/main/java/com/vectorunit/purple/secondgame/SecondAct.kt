package com.vectorunit.purple.secondgame

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.vectorunit.purple.R
import com.vectorunit.purple.databinding.ActivitySecondBinding
import kotlin.random.Random

class SecondAct : AppCompatActivity() {
    private lateinit var bkviud : ActivitySecondBinding
    private var gdsdifdos: CountDownTimer? = null
    private lateinit var totalSharedPref : SharedPreferences
    private lateinit var newWin : SharedPreferences
    private lateinit var bonusGame : SharedPreferences
    private var totalBalance : Int? = 0
    private var currentWint : Int? = 0
    private var b_to_game = 5
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bkviud = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(bkviud.root)
        totalSharedPref = getSharedPreferences("VOLCANO_BAL_SP", MODE_PRIVATE)
        newWin = getSharedPreferences("winEl",MODE_PRIVATE)
        bonusGame = getSharedPreferences("bonusEl",MODE_PRIVATE)
        b_to_game = bonusGame.getInt("bonusEl",5)

        bkviud.imCup.setOnClickListener {
            startActivity(Intent(this,RecordsActivity::class.java))
        }

        currentWint  = newWin.getInt("winEl",0)
        bkviud.tvWin.text = "Your Win : $currentWint"
        bkviud.tvBonus.text = "Bonus game after : $b_to_game"

        totalBalance = totalSharedPref.getInt(BALANCE_ELEMENTAL.toString(), 1000)
        bkviud.imMainSec.setOnClickListener {
            if(totalBalance!=0){
                isdadijsadnsa()
            } else{
                Toast.makeText(this, "Your balance is low or 0", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun isdadijsadnsa() = with(bkviud){
        var ogkkdf = 0
        if(totalBalance!!>0){
            totalBalance = totalBalance!!.minus(50)
            totalSharedPref.edit().putInt(BALANCE_ELEMENTAL.toString(),totalBalance!!).apply()
        } else{
            totalBalance = 0
            totalSharedPref.edit().putInt(BALANCE_ELEMENTAL.toString(),totalBalance!!).apply()
        }
        gdsdifdos?.cancel()
        gdsdifdos = object : CountDownTimer(5000,100){
            override fun onTick(millisUntilFinished: Long) {
                ogkkdf++
                imMainSec.isClickable = false
                imMainSec.alpha = 0.7f
                if(ogkkdf>5)ogkkdf = 0
                imageView2.setImageResource(SecEgUtils.listImgElBeam[ogkkdf])
                imageView3.setImageResource(SecEgUtils.listImgElBeam[ogkkdf])
                imageView4.setImageResource(SecEgUtils.listImgElBeam[ogkkdf])
                imageView5.setImageResource(SecEgUtils.listImgElBeam[ogkkdf])
            }

            override fun onFinish() {
                bkviud.imMainSec.isClickable = true
                aplasdlkosd()
                imMainSec.alpha = 1.0f

            }

        }.start()

    }

    private fun aplasdlkosd() =with(bkviud) {
        val sijdsiad = SecEgUtils.listImgElBeam[Random.nextInt(6)]
        val xckmcxz = SecEgUtils.listImgElBeam[Random.nextInt(6)]
        val roksdkoa= SecEgUtils.listImgElBeam[Random.nextInt(6)]
        val hfdgdfg= SecEgUtils.listImgElBeam[Random.nextInt(6)]

        imageView2.setImageResource(sijdsiad)
        imageView3.setImageResource(xckmcxz)
        imageView4.setImageResource(roksdkoa)
        imageView5.setImageResource(hfdgdfg)

        if(imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_1_sec)?.constantState
            ||imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_3_sec)?.constantState  ){

            if(currentWint!! >0){
                currentWint = currentWint!!.minus(20)
              newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"
            } else {
                currentWint = 0
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"

            }

        }

        if(imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_2_sec)?.constantState) {


            currentWint = currentWint!!.plus(50)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }


        if(imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_2)?.constantState) {
            currentWint = currentWint!!.plus(75)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }


        if(imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_3)?.constantState) {
            if(b_to_game >=0) {
                b_to_game = b_to_game.minus(1)
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }else {
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"

            }

            if(b_to_game==0){
                startActivity(Intent(this@SecondAct,BonusSecGame::class.java))
                b_to_game = 5
                bonusGame.edit().putInt("bonusEl",b_to_game).apply()
                bkviud.tvBonus.text = "Bonus game after : $b_to_game"
                finish()
            }

        }

        if(imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_3)?.constantState) {
            if(b_to_game >=0) {
                b_to_game = b_to_game.minus(1)
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }else {
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }

            if(b_to_game==0){
                startActivity(Intent(this@SecondAct,BonusSecGame::class.java))
                b_to_game = 5
                bonusGame.edit().putInt("bonusEl",b_to_game).apply()
                bkviud.tvBonus.text = "Bonus game after : $b_to_game"
                finish()
            }

        }
        if(imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_3)?.constantState) {
            if(b_to_game >=0) {
                b_to_game = b_to_game.minus(1)
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }else {
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }

            if(b_to_game==0){
                startActivity(Intent(this@SecondAct,BonusSecGame::class.java))
                b_to_game = 5
                bonusGame.edit().putInt("bonusEl",b_to_game).apply()
                bkviud.tvBonus.text = "Bonus game after : $b_to_game"
                finish()
            }

        }
        if(imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_3)?.constantState) {
            if(b_to_game >=0) {
                b_to_game = b_to_game.minus(1)
                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }else {

                bonusGame.edit().putInt("bonusEl", b_to_game).apply()
                tvBonus.text = "Bonus game after : $b_to_game"
            }

            if(b_to_game==0){
                startActivity(Intent(this@SecondAct,BonusSecGame::class.java))

                b_to_game = 5
                bonusGame.edit().putInt("bonusEl",b_to_game).apply()
                bkviud.tvBonus.text = "Bonus game after : $b_to_game"
                finish()


            }

        }

        if(imageView2.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_1)?.constantState) {


            currentWint = currentWint!!.plus(200)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_1)?.constantState) {


            currentWint = currentWint!!.plus(200)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_1)?.constantState) {


            currentWint = currentWint!!.plus(200)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_1)?.constantState) {


            currentWint = currentWint!!.plus(200)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_2)?.constantState) {


            currentWint = currentWint!!.plus(50)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_2)?.constantState) {


            currentWint = currentWint!!.plus(50)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_unique_2)?.constantState) {


            currentWint = currentWint!!.plus(50)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }



        if(imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_2_sec)?.constantState) {


            currentWint = currentWint!!.plus(70)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }


        if(imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_2_sec)?.constantState) {


            currentWint = currentWint!!.plus(70)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }


        if(imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_2_sec)?.constantState) {


            currentWint = currentWint!!.plus(70)
            newWin.edit().putInt("winEl", currentWint!!).apply()
            tvWin.text = "Your Win : $currentWint"
        }

        if(imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_1_sec)?.constantState
            ||imageView3.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_3_sec)?.constantState  ){

            if(currentWint!! >0){
                currentWint = currentWint!!.minus(50)
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"
            } else {
                currentWint = 0
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"

            }

        }

        if(imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_1_sec)?.constantState
            ||imageView4.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_3_sec)?.constantState  ){

            if(currentWint!! >0){
                currentWint = currentWint!!.minus(50)
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"
            } else {
                currentWint = 0
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"


            }

        }
        if(imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_1_sec)?.constantState
            ||imageView5.drawable.constantState == ContextCompat.getDrawable(this@SecondAct, R.drawable.elem_3_sec)?.constantState  ){

            if(currentWint!! >0){
                currentWint = currentWint!!.minus(100)
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"
            } else {
                currentWint = 0
                newWin.edit().putInt("winEl",currentWint!!).apply()
                tvWin.text = "Your Win : $currentWint"

            }

        }



    }

    override fun onDestroy() {
        super.onDestroy()
        gdsdifdos?.cancel()
    }

    companion object{
      var BALANCE_ELEMENTAL = 1000
    }
}