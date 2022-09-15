package net.ivanvega.probandointents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btn_click_actio(v: View){
        startActivity(
            Intent(
             ).apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "El Texto del Mensaje")
                type = "text/plain"
            }
        )
    }
}