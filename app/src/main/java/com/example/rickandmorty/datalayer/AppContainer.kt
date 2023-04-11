package com.example.rickandmorty.datalayer

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val rickAndMortyRepository: RickAndMortyRepository
}


class DefaultAppContainer: AppContainer {

    private val baseURL = "https://rickandmortyapi.com/api/"

    @OptIn(ExperimentalSerializationApi::class)
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val retrofitService: RickAndMortyApiService by lazy {
        retrofit.create(RickAndMortyApiService::class.java)
    }

    override val rickAndMortyRepository: RickAndMortyRepository
        get() = DefaultRickAndMortyRepository(retrofitService)

}