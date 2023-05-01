package com.example.rickandmorty.uilayer

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.rickandmorty.datalayer.RickAndMortyApplication
import com.example.rickandmorty.datalayer.RickAndMortyModule
import com.example.rickandmorty.datalayer.RickAndMortyRepository
import com.example.rickandmorty.datalayer.RickAndMortyState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class RickAndMortyViewModel @Inject constructor(app: Application) : AndroidViewModel(application = app) {

    private val retrofit = RickAndMortyModule.providesRetrofit()
    private val rickAndMortyApiService = RickAndMortyModule.providesApiService(retrofit = retrofit)
    private val rickAndMortyRepo = RickAndMortyModule.providesRickAndMortyRepository(rickAndMortyApiService = rickAndMortyApiService)

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
                RickAndMortyState.Success(rickAndMortyRepo.getCharacterDetails())
                //_rickAndMortyState.update { RickAndMortyState.Success(rickAndMortyRepository.getCharacterDetails()) }
            } catch (e: IOException) {
                RickAndMortyState.Error
            }
        }
    }

}