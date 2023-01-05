package com.vectorunit.purple.secondgame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.vectorunit.purple.databinding.DialogSecGameBinding

object DialogScreen {

    fun showdialog(context: Context,winCurrent : Int, doubles : Int){
        var dialog : AlertDialog? = null
        var sharedwin : SharedPreferences? = null
        val builder = AlertDialog.Builder(context)
        val binding = DialogSecGameBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)
         sharedwin = context.getSharedPreferences("winEl",AppCompatActivity.MODE_PRIVATE)

        binding.tvCatched.text = "You catched $doubles items"
        val calc = winCurrent * doubles / 2
        sharedwin.edit().putInt("winEl",calc).apply()
        binding.tvCalc.text = "Your new Win is : $calc"
        binding.button2.setOnClickListener {
            context.startActivity(Intent(context,SecondAct::class.java))
        }


        dialog = builder.create()
        dialog.window?.setBackgroundDrawable(null)
        dialog.show()

    }
}