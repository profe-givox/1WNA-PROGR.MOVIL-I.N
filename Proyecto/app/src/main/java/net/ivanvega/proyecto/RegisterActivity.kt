package net.ivanvega.proyecto

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var  txtEmail: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_register)

        //Recuperar parametros que se envian desde otra actividad
        val titulo = intent.getStringExtra("par2")
        val accion = intent.getIntExtra("par1",-1)

        //propiedad title de laa activisdad
        title = titulo
        Toast.makeText(applicationContext,
            "Accion: $accion", Toast.LENGTH_LONG).show()


    }

}