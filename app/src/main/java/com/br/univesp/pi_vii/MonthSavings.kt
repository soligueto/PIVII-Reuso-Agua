package com.br.univesp.pi_vii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MonthSavings : AppCompatActivity() {

    private lateinit var firstMonth : TextView
    private lateinit var secondMounth : TextView
    private lateinit var firstValue : TextView
    private lateinit var secondValue : TextView
    private lateinit var mounths : TextView
    private lateinit var ltsEconomy : TextView
    private lateinit var valueEconomy : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_month_savings)

        firstMonth = findViewById<TextView>(R.id.txtFirstMonth)
        secondMounth = findViewById<TextView>(R.id.txtSecondMounth)
        firstValue = findViewById<TextView>(R.id.txtFirstValue)
        secondValue = findViewById<TextView>(R.id.txtSecondValue)
        mounths = findViewById<TextView>(R.id.txtCompareMounths)
        ltsEconomy = findViewById<TextView>(R.id.txtEconomyLts)
        valueEconomy = findViewById<TextView>(R.id.txtEconomyValue)

        val backMain = findViewById<Button>(R.id.btnBackM)

        economyFunction()

        backMain.setOnClickListener(){
            returnFun()
        }
    }

    private fun economyFunction() {

        var firstM = 20
        var secondM = 50

        var totalLts = secondM - firstM

        var mc = 18.10 / 10
        var mcLts = totalLts / 1000

        var totalEconomy = mc * mcLts

        totalEconomy.toDouble()
        totalEconomy.toString()

        totalEconomy = 1.81

        "Economia : R\$ $totalEconomy ".also { valueEconomy.text = it }

    }

    private fun returnFun() {
        val monitoring = Intent(this, ControlMenu::class.java)
        startActivity(monitoring)
    }
}