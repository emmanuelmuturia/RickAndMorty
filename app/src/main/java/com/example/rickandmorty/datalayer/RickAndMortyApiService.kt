package com.example.rickandmorty.datalayer

import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("api/character")
    suspend fun getCharacter(): List<RickAndMortyModel>

}