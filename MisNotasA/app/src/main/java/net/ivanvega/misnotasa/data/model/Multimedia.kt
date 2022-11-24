package net.ivanvega.misnotasa.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Multimedia (
    @PrimaryKey(autoGenerate = true)
    var uid: Long, var idNota: Long, val tipo: Int, val path: String  )
