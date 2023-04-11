package com.example.rickandmorty.datalayer

sealed interface RickAndMortyState {
    data class Success(val characters: List<RickAndMortyModel>): RickAndMortyState
    object Loading: RickAndMortyState
    object Error: RickAndMortyState
}