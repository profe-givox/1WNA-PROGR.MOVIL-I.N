package net.ivanvega.mirollera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)


        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)
        img = findViewById(R.id.imgRoller)

        /*boton.setOnClickListener(
            View.OnClickListener {
                Toast.makeText(applicationContext,
                    "Boton presionafdo",
                    Toast.LENGTH_LONG
                    ).show()
            }
        )*/

        img.setImageDrawable(resources.getDrawable(R.drawable.dice_3))

        boton.setOnClickListener {
            val al = diceRoller()

            Toast.makeText(
                applicationContext,
                "Boton presionado aleatorio " + al,
                Toast.LENGTH_LONG
            ).show()



            val idImagenAl = when (al){
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.empty_dice
            }

            img.setImageResource(idImagenAl)

            lbl.text = al.toString()

        }
    }

    fun diceRoller () : Int {
        return (1..6).random()
    }

}