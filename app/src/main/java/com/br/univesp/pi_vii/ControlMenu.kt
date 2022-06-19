package com.br.univesp.pi_vii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ControlMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control_menu)

        val bombFunction = findViewById<Button>(R.id.btnFuncBomb)
        val monthSavings = findViewById<Button>(R.id.btnEconMen)
        val disposal = findViewById<Button>(R.id.btnDescarte)
        val reuse = findViewById<Button>(R.id.btnReuso)
        val backMain = findViewById<Button>(R.id.btnBackCM)

        bombFunction.setOnClickListener(){
            bombFun()
        }

        monthSavings.setOnClickListener(){
            savingsFun()
        }

        disposal.setOnClickListener(){
            disposalFun()
        }

        reuse.setOnClickListener(){
            reuseFun()
        }

        backMain.setOnClickListener(){
            returnFun()
        }
    }

    private fun bombFun() {
        val monitoring = Intent(this, BombFunction::class.java)
        startActivity(monitoring)
    }

    private fun savingsFun() {
        val monitoring = Intent(this, MonthSavings::class.java)
        startActivity(monitoring)
    }

    private fun disposalFun() {
        val monitoring = Intent(this, Disposal::class.java)
        startActivity(monitoring)
    }

    private fun reuseFun() {
        val monitoring = Intent(this, Reuse::class.java)
        startActivity(monitoring)
    }

    private fun returnFun() {
        val monitoring = Intent(this, MainActivity::class.java)
        startActivity(monitoring)
    }
}