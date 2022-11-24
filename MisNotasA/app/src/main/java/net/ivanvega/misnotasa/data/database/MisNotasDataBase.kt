package net.ivanvega.misnotasa.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import net.ivanvega.misnotasa.data.dao.MultimediaDao
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Multimedia
import net.ivanvega.misnotasa.data.model.Nota
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(Nota::class, Multimedia::class), version = 1)
 abstract class MisNotasDataBase: RoomDatabase() {
     abstract fun notaDao(): NotaDao
     abstract fun multimediaDao(): MultimediaDao

    private class NotaDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch (Dispatchers.IO){
                    var notaDao = database.notaDao()

                    // Delete all content here.
                    notaDao.deleteAll()

                    // Add sample words.
                    val nota1 = Nota(0,"Mi primer nota",
                        "Registro", 0, null,false)
                    val nota2 = Nota(0,"Mi segunda nota",
                        "Registro", 0, null,false)
                    val nota3 = Nota(0,"Mi tercer nota",
                        "Registro", 0, null,false)

                    notaDao.insertAsync(nota1)
                    notaDao.insertAsync(nota2)
                    notaDao.insertAsync(nota3)

                }
            }
        }
    }


    companion object{
        @Volatile
        private var INSTANCE: MisNotasDataBase?=null

         val databaseexecutor :
                ExecutorService =
            Executors.newFixedThreadPool(4)

        fun getDatabase(context: Context, scope: CoroutineScope): MisNotasDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context, MisNotasDataBase::class.java,
                    "midatabase"
                ).addCallback(NotaDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
     }

}

