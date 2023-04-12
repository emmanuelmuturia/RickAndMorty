package com.example.rickandmorty.uilayer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.rickandmorty.R
import com.example.rickandmorty.datalayer.RickAndMortyDto


@Composable
fun RickAndMortyApp(rickAndMortyViewModel: RickAndMortyViewModel, modifier: Modifier = Modifier) {

    //val myCharacterState by rickAndMortyViewModel.rickAndMortyState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = {"Rick and Morty"}) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = Color.Yellow
        ) {
            HomeScreen(rickAndMortyState = rickAndMortyViewModel.rickAndMortyState)
        }
    }
}


@Composable
fun RickAndMortyScreen(characters: List<RickAndMortyDto>) {
    LazyColumn {
        items(characters) { myCharacters ->
            RickAndMortyCard(myCharacters = myCharacters)
        }
    }
}


@Composable
fun RickAndMortyCard(myCharacters: RickAndMortyDto) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .aspectRatio(1f),
        elevation = 7.dp,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .padding(7.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(myCharacters.image)
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentScale = ContentScale.Crop,
                contentDescription = "Rick and Morty"
            )
                Text(modifier = Modifier.padding(7.dp), text = "Name: ${myCharacters.name}")
                Text(modifier = Modifier.padding(7.dp), text = "Status: ${myCharacters.status}")
                Text(modifier = Modifier.padding(7.dp), text = "Species: ${myCharacters.species}")
                Text(modifier = Modifier.padding(7.dp), text = "Gender: ${myCharacters.gender}")
                //Text(modifier = Modifier.padding(7.dp), text = "Origin: ${myCharacters.origin}")
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun RickAndMortyScreenPreview() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        RickAndMortyCard(myCharacters = RickAndMortyDto(1, "Rick", "Alive", "Human", "Unknown", image = "${R.drawable.img}"))
    }
}





