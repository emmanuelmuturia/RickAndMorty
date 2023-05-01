package com.example.rickandmorty.datalayer

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RickAndMortyModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
        }

        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): RickAndMortyApiService {
        return retrofit.create(RickAndMortyApiService::class.java)
    }

    @Singleton
    @Provides
    fun providesRickAndMortyRepository(rickAndMortyApiService: RickAndMortyApiService): DefaultRickAndMortyRepository {
        return DefaultRickAndMortyRepository(rickAndMortyApiService = rickAndMortyApiService)
    }

}