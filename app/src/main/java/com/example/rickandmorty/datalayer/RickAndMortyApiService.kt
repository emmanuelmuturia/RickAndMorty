package com.example.rickandmorty.datalayer

import retrofit2.http.GET

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacter(): RickAndMortyResponse

}