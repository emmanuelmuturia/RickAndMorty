package com.example.rickandmorty.datalayer

import com.example.rickandmorty.uilayer.RickAndMortyViewModel

interface RickAndMortyRepository {
    suspend fun getCharacterDetails(): List<RickAndMortyModel>
}


class DefaultRickAndMortyRepository(private val rickAndMortyApiService: RickAndMortyApiService) : RickAndMortyRepository {
    override suspend fun getCharacterDetails(): List<RickAndMortyModel> {
        return rickAndMortyApiService.getCharacter()
    }
}