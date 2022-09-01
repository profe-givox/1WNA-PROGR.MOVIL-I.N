package net.ivanvega.mirollera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)

        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)

        /*boton.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext,
                    "Boton presionafdo",
                    Toast.LENGTH_LONG
                    ).show()
            }
        )*/

        boton.setOnClickListener {
            val al = diceRoller()
            Toast.makeText(
                applicationContext,
                "Boton presionado aleatorio " + al,
                Toast.LENGTH_LONG
            ).show()

            lbl.text = al.toString()

        }
    }

    fun diceRoller () : Int {
        return (1..6).random()
    }

}