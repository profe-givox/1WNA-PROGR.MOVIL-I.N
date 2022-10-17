package net.ivanvega.misnotasa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import androidx.room.RoomDatabase
import net.ivanvega.misnotasa.data.database.MisNotasDataBase
import net.ivanvega.misnotasa.data.model.Nota

class MainActivity : AppCompatActivity() {

    private lateinit var db: MisNotasDataBase
    private lateinit var btnI: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db =
            MisNotasDataBase.getDatabase(applicationContext)

        btnI = findViewById<Button>(R.id.buttonInsert)
        btnI.setOnClickListener {

            MisNotasDataBase.databaseexecutor.execute {
                val dao = db.notaDao()

                val nota = Nota(0,"Mi primer nota",
                    "Registro", 0, null,false)

                dao.insert(nota)

                val lsN = dao.getAll()

                for (item in lsN){
                    Log.i("NOTASX", "${item.uid}  ${item.titulo}")
                }




            }
        }
    }
}