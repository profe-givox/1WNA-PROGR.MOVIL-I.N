package net.ivanvega.proyecto

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    lateinit var  txtEmail: EditText
    lateinit var txtName : EditText
    lateinit var btnSave: Button

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

        txtEmail = findViewById(R.id.txtEmail)
        txtName = findViewById(R.id.txtName)
        btnSave = findViewById(R.id.btnSaveRegister)
        btnSave.setOnClickListener {
            val datos = Intent()
            datos.putExtra("email", txtEmail.text.toString())
            datos.putExtra("name", txtName.text.toString())
            setResult(RESULT_OK, datos)
            finish()

        }



    }

}