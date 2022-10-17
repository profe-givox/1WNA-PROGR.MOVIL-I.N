package net.ivanvega.misnotasa.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Nota
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(entities = arrayOf(Nota::class), version = 1)
 abstract class MisNotasDataBase: RoomDatabase() {
     abstract fun notaDao(): NotaDao

     companion object{
        private var INSTANCE: MisNotasDataBase?=null

         val databaseexecutor :
                ExecutorService =
            Executors.newFixedThreadPool(4)

        fun getDatabase(context: Context): MisNotasDataBase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context, MisNotasDataBase::class.java,
                    "midatabase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
     }

}