package net.ivanvega.proyecto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class IntentsSistema : AppCompatActivity() {
    lateinit var  btnI1 : Button
    lateinit var  btnI2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents_sistema)

        btnI1 = findViewById(R.id.btnIntent1)
        btnI2 = findViewById(R.id.btnIntent2)
        btnI1.setOnClickListener {

            //URI: Son cadenas que indican la ubicación de un recurso
            // o una accion a especicar sobre un recuro

            val action_dial =
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:4451002345") )

            startActivity(action_dial)

        }
        btnI2.setOnClickListener {
          val action_view = Intent(
              Intent.ACTION_VIEW,
              Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
          )
          startActivity(action_view)
        }


    }
}