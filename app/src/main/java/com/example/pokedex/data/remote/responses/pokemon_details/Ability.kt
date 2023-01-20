package com.example.pokedex.data.remote.responses.pokemon_details

data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)