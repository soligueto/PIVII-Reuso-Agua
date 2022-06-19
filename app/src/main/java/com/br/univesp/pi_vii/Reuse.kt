package com.br.univesp.pi_vii

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class Reuse : AppCompatActivity() {

    private lateinit var result : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reuse)

        val backMain = findViewById<Button>(R.id.btnBackR)

        val refreshStatus = findViewById<Button>(R.id.btnRefreshR)

        result = findViewById<TextView>(R.id.txtLevelReuse)

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

                var level = ""

                for (i in 0 until jsonArray.length()) {
                    level = jsonArray.getJSONObject(i).getString("field4")
                }

                if (level == "null"){
                    level = "0"
                }

                runOnUiThread {

                    "$level %".also { result.text = it }

                }
            } finally {
                conn.disconnect()
            }
        }.start()

    }
}