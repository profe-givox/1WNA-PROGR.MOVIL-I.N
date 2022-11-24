package net.ivanvega.misnotasa.repository

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import net.ivanvega.misnotasa.data.model.Multimedia
import net.ivanvega.misnotasa.data.model.Nota

class NotaViewModel (private val repositoryN: NotasRepository, private val repositoryM: MultimediaRepository)
    : ViewModel() {
    var cont = 0
    val allNotas : LiveData<List<Nota>> = repositoryN.allNotas.asLiveData()

    fun insertarAsync(nota: Nota) = viewModelScope.launch {
        val idNota = repositoryN.insertarAsync(nota)

    }
    fun insertarAsync(nota: Nota, multimedia: List<Multimedia>) = viewModelScope.launch {
        val idNota = repositoryN.insertarAsync(nota)
        multimedia.forEach { multimedia -> multimedia.idNota=idNota }
        repositoryM.insert(multimedia)
    }

}

class NotaViewModelFactory(private val repositoryN: NotasRepository,private val repositoryM: MultimediaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NotaViewModel(repositoryN, repositoryM ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
