package com.example.pokedex.di

import com.example.pokedex.data.remote.PokeApiService
import com.example.pokedex.repository.PokemonRepository
import com.example.pokedex.repository.PokemonRepositoryImpl
import com.example.pokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesAoi(): PokeApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesRepository(apiService: PokeApiService) : PokemonRepository{
        return PokemonRepositoryImpl(apiService)
    }
}
