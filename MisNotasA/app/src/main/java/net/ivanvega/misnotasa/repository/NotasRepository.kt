package net.ivanvega.misnotasa.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import net.ivanvega.misnotasa.data.dao.NotaDao
import net.ivanvega.misnotasa.data.model.Nota

/**
 * Abstracted Repository as promoted by the Architecture Guide.
 * https://developer.android.com/topic/libraries/architecture/guide.html
 */
class NotasRepository (private val notaDao:  NotaDao){
    val allNotas : Flow<List<Nota>> =  notaDao.getAllOrder()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertarAsync(nota: Nota){
        notaDao.insertAsync(nota)
    }

}