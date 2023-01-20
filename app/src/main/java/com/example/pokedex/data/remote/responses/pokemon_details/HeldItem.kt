package com.example.pokedex.data.remote.responses.pokemon_details

data class HeldItem(
    val item: Item,
    val version_details: List<VersionDetail>
)