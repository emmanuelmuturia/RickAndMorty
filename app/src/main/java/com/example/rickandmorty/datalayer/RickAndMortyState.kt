package com.example.rickandmorty.datalayer

import retrofit2.Response

sealed interface RickAndMortyState {
    data class Success(val characters: List<RickAndMortyDto>): RickAndMortyState
    object Loading: RickAndMortyState
    object Error: RickAndMortyState
}