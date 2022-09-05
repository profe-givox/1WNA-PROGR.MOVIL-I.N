package net.ivanvega.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {
    lateinit var txtUser : EditText
    lateinit var txtPass : EditText
    lateinit var btnEntrar : Button
    lateinit var btnRegistrar : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        txtUser =  findViewById(R.id.txtUsuario)
        txtPass =  findViewById(R.id.txtPass)

        btnEntrar = findViewById(R.id.btnEntrar)
        btnRegistrar = findViewById(R.id.btnRegister)

        btnRegistrar.setOnClickListener {

            //Para abrir otra activity se debe:
            //Crear un Intent de un Activity
            val intent_activity = Intent(
                applicationContext, RegisterActivity::class.java
            )

            //Abiri la activity
            startActivity(intent_activity)

        }

    }
}