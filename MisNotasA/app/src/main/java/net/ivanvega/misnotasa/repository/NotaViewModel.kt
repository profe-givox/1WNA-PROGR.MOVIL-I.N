package net.ivanvega.misnotasa.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import net.ivanvega.misnotasa.data.model.Nota

class NotaViewModel (private val repository: NotasRepository)
    : ViewModel() {
        val allNotas : LiveData<List<Nota>> = repository.allNotas as LiveData<List<Nota>>

    fun insertarAsync(nota: Nota) = viewModelScope.launch {
        repository.insertarAsync(nota)
    }

}