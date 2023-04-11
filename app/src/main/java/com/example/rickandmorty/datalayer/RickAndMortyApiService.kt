package com.example.rickandmorty.datalayer

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApiService {

    @GET("character")
    suspend fun getCharacter(): List<RickAndMortyList>

}