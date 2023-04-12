package com.example.rickandmorty.datalayer

import com.example.rickandmorty.uilayer.RickAndMortyViewModel
import retrofit2.Response

interface RickAndMortyRepository {
    suspend fun getCharacterDetails(): List<RickAndMortyDto>
}


class DefaultRickAndMortyRepository(private val rickAndMortyApiService: RickAndMortyApiService) : RickAndMortyRepository {
    override suspend fun getCharacterDetails(): List<RickAndMortyDto> {
        val response = rickAndMortyApiService.getCharacter()
        return response.results
        //return rickAndMortyApiService.getCharacter()
    }
}