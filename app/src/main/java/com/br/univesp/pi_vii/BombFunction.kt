package com.br.univesp.pi_vii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class BombFunction : AppCompatActivity() {

    private lateinit var result : TextView
    private lateinit var bombActivity : TextView
    private lateinit var bombInative : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bomb_function)

        val backMain = findViewById<Button>(R.id.btnBackB)

        val refreshStatus = findViewById<Button>(R.id.btnRefreshB)

        bombActivity = findViewById<TextView>(R.id.txtActive)

        bombInative = findViewById<TextView>(R.id.txtDesactive)

        result = findViewById<TextView>(R.id.textExample)

        refresh()

        refreshStatus.setOnClickListener(){
            refresh()
        }

        backMain.setOnClickListener(){
            returnFun()
        }
    }

    private fun returnFun() {
        val monitoring = Intent(this, ControlMenu::class.java)
        startActivity(monitoring)
    }

    private fun refresh() {

        Thread {
            // processo em paralelo

            val url = URL("https://api.thingspeak.com/channels/1753394/feeds.json?results=2")

            val conn = url.openConnection() as HttpURLConnection



            try {
                val data = conn.inputStream.bufferedReader().readText()

                val objectJson = JSONObject(data)

                val jsonArray = objectJson.getJSONArray("feeds")

                var bFunc = ""
                var fluxo = ""

                for (i in 0 until jsonArray.length()) {

                    bFunc = jsonArray.getJSONObject(i).getString("field6")
                    fluxo = jsonArray.getJSONObject(i).getString("field2")

                }

                runOnUiThread {

                    if (fluxo == "null"){
                        fluxo = "0"
                    }

                    val fluxoView = fluxo.toDouble().dec()

                    if (bFunc == "null"){
                        bFunc = "0"
                    }

//                    simulação de bomba ligada
//                    "0".also { bFunc = it }
//                    var fluxoView = 0.0

                    if (bFunc == "1"){
                        bombActivity.visibility = View.VISIBLE
                        "Fluxo : $fluxoView ml/s".also { result.text = it }
                        result.visibility = View.VISIBLE
                    } else {
                        bombActivity.visibility = View.INVISIBLE
                        bombInative.visibility = View.VISIBLE
                    }
                }
            } finally {
                conn.disconnect()
            }
        }.start()
    }

}