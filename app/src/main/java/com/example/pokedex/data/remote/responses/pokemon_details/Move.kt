package com.example.pokedex.data.remote.responses.pokemon_details

data class Move(
    val move: MoveX,
    val version_group_details: List<VersionGroupDetail>
)