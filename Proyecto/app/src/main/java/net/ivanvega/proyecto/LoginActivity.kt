package net.ivanvega.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts

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
            /*
            val intent_activity = Intent(
                applicationContext, RegisterActivity::class.java
            )*/

            val intent_activity = Intent(
                applicationContext, RegisterActivity::class.java
            )
            intent_activity.putExtra("par1",0)
            intent_activity.putExtra("par2","Register")

            /*val intent_activity = Intent(
                applicationContext, RegisterActivity::class.java
            ).apply {
                this.putExtra("par1",0)
                this.putExtra("par2","Register")
            }*/

            //Abiri la activity
            //startActivity(intent_activity)


            //Para abrir una actividad que devuelve parametros  se debe construir los
            //siguiente


            //2) Usar el metodo starActivityFOrResult

             val activityResultLauncher =
                 registerForActivityResult(
                ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback {
                    it.data
                    it.resultCode
                }
                )


            activityResultLauncher.launch(intent_activity)

        }

    }
}