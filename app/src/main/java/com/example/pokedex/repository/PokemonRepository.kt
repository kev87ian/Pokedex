package com.example.pokedex.repository

import com.example.pokedex.data.remote.responses.pokemon_details.Pokemon
import com.example.pokedex.data.remote.responses.pokemon_list.PokemonList
import com.example.pokedex.util.Resource

interface PokemonRepository {
    suspend fun getPokemonList(limit:Int, offset:Int) : Resource<PokemonList>
    suspend fun getPokemonInfo(pokemonName:String) : Resource<Pokemon>
}