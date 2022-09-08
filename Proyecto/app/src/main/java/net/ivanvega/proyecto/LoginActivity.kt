package net.ivanvega.proyecto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    lateinit var txtUser : EditText
    lateinit var txtPass : EditText
    lateinit var btnEntrar : Button
    lateinit var btnRegistrar : Button

    //Objeto que permite mandar llamar una actividad que devolvera un resultado
    lateinit var  activityResultLauncher : ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        activityResultLauncher =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult(),
                ActivityResultCallback {
                    if( it.resultCode== RESULT_OK){
                        txtUser.text = Editable.Factory.getInstance().newEditable(it?.data?.getStringExtra("email"))
                        val email =  it?.data?.getStringExtra("email")
                         //it.data.getStringExtra("name")
                        Toast.makeText(applicationContext,
                            "email: ${email}", Toast.LENGTH_LONG).show()


                    }

                }
            )

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


            //2) Usar el metodo
            activityResultLauncher.launch(intent_activity)

        }

    }
}