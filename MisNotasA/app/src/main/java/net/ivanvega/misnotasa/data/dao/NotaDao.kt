package net.ivanvega.misnotasa.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

import net.ivanvega.misnotasa.data.model.Nota


@Dao
interface   NotaDao {

    @Insert
    suspend fun insertAsync(vararg nota: Nota)

    @Update
    fun update(nota: Nota)
    @Delete
    fun delete(nota: Nota)

    @Query("select * from Nota")
     fun getAll() : List<Nota>

     @Query("SELECT * FROM Nota WHERE uid = :userId")
    fun getOneById(userId: Int): Nota

    @Query("select * from Nota order by fecha desc")
    fun getAllOrder() : Flow<List<Nota>>

    @Query("DELETE FROM Nota")
    suspend fun deleteAll() : Int

}