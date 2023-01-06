package com.vectorunit.purple.firstgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vectorunit.purple.R

class FirstAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
    }




//    override fun onBackPressed() {
//        val fragmentInstance =
//            supportFragmentManager.findFragmentById(R.id.frag_hold)?.childFragmentManager?.fragments?.last()
//        if (fragmentInstance is MainLooadFragment || fragmentInstance is InitFragment) {
//            val intent = Intent(this, RegAct::class.java)
//            startActivity(intent)
//            finish()
//        } else{
//            super.onBackPressed()
//        }
//    }
}