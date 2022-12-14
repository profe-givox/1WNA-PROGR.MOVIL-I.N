package net.ivanvega.proyecto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class IntentsSistema : AppCompatActivity() {
    lateinit var  btnI1 : Button
    lateinit var  btnI2  : Button
            lateinit var btnI3: Button
    lateinit var actReslLaun : ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents_sistema)

        btnI1 = findViewById(R.id.btnIntent1)
        btnI2 = findViewById(R.id.btnIntent2)
        btnI3 = findViewById(R.id.btnSend)
        btnI1.setOnClickListener {

            //URI: Son cadenas que indican la ubicación de un recurso
            // o una accion a especicar sobre un recuro

            val action_dial =
                Intent(Intent.ACTION_DIAL, Uri.parse("tel:4451002345") )

            startActivity(action_dial)

        }
        btnI2.setOnClickListener {
          val action_view = Intent  (
              Intent.ACTION_VIEW,
              //Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California")
              Uri.parse("https://sicenet.itsur.edu.mx")
          )
          startActivity(action_view)
        }

        btnI3.setOnClickListener {
             val intent_send = Intent(Intent.ACTION_SEND).apply {
         //   val intent_send = Intent("net.ivanvega.proyecto.ACTIVITY_SEND").apply {
                 type = "text/plain"
                 putExtra(Intent.EXTRA_EMAIL, arrayOf("jan@example.com")) // recipients
                 putExtra(Intent.EXTRA_SUBJECT, "Email subject")
                 putExtra(Intent.EXTRA_TEXT, "Email message text")
             }
            //startActivity(intent_send)
            actReslLaun.launch("audio/*")
        }

        actReslLaun = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                Toast.makeText(applicationContext,
                        "Uri: ${it.toString()}",
                    Toast.LENGTH_LONG).show()

                Log.e("ESTETAG",
                    "Uri: ${it.toString()}" )

            }
        )

    }

    override fun onStart() {
        super.onStart()
        Log.i("CILCLOVIDA", "Paso por onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CILCLOVIDA", "Paso por onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("CILCLOVIDA", "Paso por onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("CILCLOVIDA", "Paso por onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("CILCLOVIDA", "Paso por onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CILCLOVIDA", "Paso por onRestar")
    }

}