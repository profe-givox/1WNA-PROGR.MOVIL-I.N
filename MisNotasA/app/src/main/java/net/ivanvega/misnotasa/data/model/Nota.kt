package net.ivanvega.misnotasa.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Nota(

    @PrimaryKey(autoGenerate = true)
    val uid: Int,
    val titulo: String,
    val descripcion: String,
    val tipo: Int,
    val fecha: Date?,
    val completada: Boolean
)