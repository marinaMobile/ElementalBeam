package com.vectorunit.purple.secondgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vectorunit.purple.databinding.ActivityRecordsBinding
import kotlin.random.Random

class RecordsActivity : AppCompatActivity() {
    private lateinit var qopqkwokq : ActivityRecordsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        qopqkwokq = ActivityRecordsBinding.inflate(layoutInflater)
        setContentView(qopqkwokq.root)
        qopqkwokq.osdkosdk.text = SecEgUtils.textWinners[Random.nextInt(6)]
        qopqkwokq.xockczxo.text = SecEgUtils.textWinners[Random.nextInt(6)]
        qopqkwokq.opsplcp.text = SecEgUtils.textWinners[Random.nextInt(6)]
        qopqkwokq.sodkosdka.setOnClickListener {
            startActivity(Intent(this,SecondAct::class.java))
        }
    }
}