package com.example.rickandmorty.uilayer

import androidx.compose.runtime.Composable
import com.example.rickandmorty.datalayer.RickAndMortyState

@Composable
fun HomeScreen(rickAndMortyState: RickAndMortyState) {
    when(rickAndMortyState) {
        is RickAndMortyState.Success -> RickAndMortyScreen(characters = rickAndMortyState.characters)
        is RickAndMortyState.Loading -> RickAndMortyLoadingScreen()
        is RickAndMortyState.Error -> RickAndMortyErrorScreen()
    }
}
