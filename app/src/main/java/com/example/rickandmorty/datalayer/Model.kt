package com.example.rickandmorty.datalayer

import android.icu.text.IDNA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponse(
    @SerialName("info") val info: String,
    @SerialName("results") val results: RickAndMortyModel
)

@Serializable
data class RickAndMortyModel(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("status") val status: String,
    @SerialName("species") val species: String,
    @SerialName("gender") val gender: String,
    @SerialName("origin") val origin: Origin,
    @SerialName("image") val image: String
)


@Serializable
data class Origin(
    @SerialName(value = "name")
    val originName: String
)