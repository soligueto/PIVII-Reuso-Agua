package com.br.univesp.pi_vii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.mainStartButton)

        val finishButton = findViewById<Button>(R.id.mainExitButton)

        startButton.setOnClickListener(){
            startFun()
        }

        finishButton.setOnClickListener{
            finishFun()
        }

    }


    private fun startFun() {
        val monitoring = Intent(this, ControlMenu::class.java)
        startActivity(monitoring)
    }

    private fun finishFun() {
        finishAffinity()
    }


}