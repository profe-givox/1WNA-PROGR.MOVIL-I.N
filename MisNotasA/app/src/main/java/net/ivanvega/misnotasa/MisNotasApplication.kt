package net.ivanvega.misnotasa

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import net.ivanvega.misnotasa.data.database.MisNotasDataBase
import net.ivanvega.misnotasa.repository.MultimediaRepository
import net.ivanvega.misnotasa.repository.NotasRepository

class MisNotasApplication : Application() {
    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { MisNotasDataBase.getDatabase(this, applicationScope) }
    val repositoryN by lazy { NotasRepository(database.notaDao()) }
    val repositoryM by lazy { MultimediaRepository(database.multimediaDao() )}

}