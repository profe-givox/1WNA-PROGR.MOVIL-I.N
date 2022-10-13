package net.ivanvega.misnotasa.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Nota

@Database(entities = [Nota::class], version = 1)
abstract class MisNotasDataBase: RoomDatabase() {
    abstract fun notaDao(): NotaDao
}