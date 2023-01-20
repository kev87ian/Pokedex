package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.data.remote.responses.pokemon_details.Pokemon
import com.example.pokedex.data.remote.responses.pokemon_list.PokemonList
import com.example.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is IOException -> {
                    return Resource.Error(null, "Ensure you have an internet connection")
                }
                is HttpException -> {
                    return Resource.Error(null, "Unable to reach servers. Please retry.")
                }
                else -> {
                    return Resource.Error(null, e.localizedMessage!!)
                }
            }
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return try {
            val response = api.getPokemonInfo(pokemonName)
            return Resource.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is IOException -> {
                    return Resource.Error(null, "Ensure you have an active internet connection")
                }
                is HttpException -> {
                    return Resource.Error(null, "We're unable to reach servers. Please retry")
                }
                else -> return Resource.Error(null, e.localizedMessage!!)
            }
        }
    }
}
