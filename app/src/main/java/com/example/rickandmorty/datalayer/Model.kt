package com.example.rickandmorty.datalayer

import android.icu.text.IDNA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Info(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?
)


@Serializable
data class RickAndMortyModel(
    val info: String,
    val results: List<RickAndMortyModel>?,
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val origin: Origin,
    val image: String
)


@Serializable
data class CharacterResponse(
    val info: Info,
    val results: List<RickAndMortyModel>
)


@Serializable
data class Location(
    val name: String,
    val url: String
)


@Serializable
data class Origin(
    @SerialName(value = "name")
    val originName: String
)