package net.ivanvega.misnotasa.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Nota

class NotasRepository (private val notaDao:  NotaDao){
    val allNotas : Flow<List<Nota>> =  notaDao.getAllOrder()

    suspend fun insertarAsync(nota: Nota){
        notaDao.insertAsync(nota)
    }

}