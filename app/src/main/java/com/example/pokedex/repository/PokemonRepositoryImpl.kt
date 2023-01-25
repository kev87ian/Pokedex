package com.example.pokedex.repository

import com.example.pokedex.data.remote.PokeApiService
import com.example.pokedex.data.remote.responses.pokemon_details.Pokemon
import com.example.pokedex.data.remote.responses.pokemon_list.PokemonList
import com.example.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@ActivityScoped
class PokemonRepositoryImpl @Inject constructor(
    private val apiService: PokeApiService
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        return try {
            val response = apiService.getPokemonList(limit, offset)
            return Resource.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is IOException -> Resource.Error(null, "Ensure you have an active internet connection")
                is HttpException -> Resource.Error(null, "We're having trouble reaching the servers. Please try again later.")
                else -> Resource.Error(null, e.localizedMessage!!)
            }
        }
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        return try {
            val response = apiService.getPokemonInfo(pokemonName)
            return Resource.Success(response)
        } catch (e: Exception) {
            e.printStackTrace()
            when (e) {
                is IOException -> Resource.Error(null, "Ensure you have an active internet connection")
                is HttpException -> Resource.Error(null, "We're having trouble reaching the servers. Please try again later.")
                else -> Resource.Error(null, e.localizedMessage!!)
            }
        }
    }
}
