package net.ivanvega.misnotasa.data.dao

import androidx.room.Dao
import androidx.room.Insert
import net.ivanvega.misnotasa.data.model.Multimedia

@Dao
interface MultimediaDao {
    @Insert
    suspend fun insert( multimedia: List<Multimedia>)

}