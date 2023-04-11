package com.example.rickandmorty.datalayer

import android.icu.text.IDNA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*@Serializable
data class RickAndMortyModel(
    val info: String,
    val results: List<RickAndMortyModel>,
)*/


@Serializable
@SerialName(value = "results")
data class RickAndMortyList(
    @SerialName(value = "id") val id: Int,
    @SerialName(value = "name") val name: String,
    @SerialName(value = "status") val status: String,
    @SerialName(value = "species") val species: String,
    @SerialName(value = "gender") val gender: String,
    @SerialName(value = "origin") val origin: String,
    @SerialName(value = "image") val image: String
)