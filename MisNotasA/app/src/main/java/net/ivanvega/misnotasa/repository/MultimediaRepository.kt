package net.ivanvega.misnotasa.repository

import net.ivanvega.misnotasa.data.dao.MultimediaDao
import net.ivanvega.misnotasa.data.model.Multimedia

class MultimediaRepository(private val multimediaDao: MultimediaDao) {
    suspend fun insert(multimedia: List<Multimedia>){
        multimediaDao.insert(multimedia)
    }
}