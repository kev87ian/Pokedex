package com.example.pokedex.data.remote.responses.pokemon_details


import com.google.gson.annotations.SerializedName

data class VersionDetail(
    @SerializedName("rarity")
    val rarity: Int,
    @SerializedName("version")
    val version: Version
)