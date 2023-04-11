package com.example.rickandmorty.uilayer

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rickandmorty.RickAndMortyApplication
import com.example.rickandmorty.datalayer.RickAndMortyRepository
import com.example.rickandmorty.datalayer.RickAndMortyState
import kotlinx.coroutines.launch
import java.io.IOException

class RickAndMortyViewModel(private val rickAndMortyRepository: RickAndMortyRepository) : ViewModel() {

    /*private var _rickAndMortyState = MutableStateFlow<RickAndMortyState>(RickAndMortyState.Loading)
    val rickAndMortyState: StateFlow<RickAndMortyState> = _rickAndMortyState.asStateFlow()*/

    var rickAndMortyState: RickAndMortyState by mutableStateOf(RickAndMortyState.Loading)
        private set

    init {
        getCharacter()
    }

    private fun getCharacter() {
        viewModelScope.launch {
            rickAndMortyState = RickAndMortyState.Loading
            /*val myCharacter = rickAndMortyRepository.getCharacterDetails()
            _rickAndMortyState.update { RickAndMortyState.Loading }*/
            rickAndMortyState = try {
                RickAndMortyState.Success(rickAndMortyRepository.getCharacterDetails())
                //_rickAndMortyState.update { RickAndMortyState.Success(rickAndMortyRepository.getCharacterDetails()) }
            } catch (e: IOException) {
                RickAndMortyState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RickAndMortyApplication)
                val rickAndMortyRepository = application.container.rickAndMortyRepository
                RickAndMortyViewModel(rickAndMortyRepository = rickAndMortyRepository)
            }
        }
    }

}