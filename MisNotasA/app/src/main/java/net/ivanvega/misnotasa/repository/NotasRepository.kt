package net.ivanvega.misnotasa.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Nota

class NotasRepository (private val notaDao:  NotaDao){
    val allNotas : Flow<List<Nota>> =  notaDao.getAllOrder()

    fun insertar(nota: Nota){
        notaDao.insert(nota)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertarAsync(nota: Nota){
        notaDao.insert(nota)
    }

}