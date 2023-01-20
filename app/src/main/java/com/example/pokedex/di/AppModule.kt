package com.example.pokedex.di

import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.repository.PokemonRepository
import com.example.pokedex.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun providesAoi() : PokeApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokeApi::class.java)
    }


    @Provides
    @Singleton
    fun providesRepository(
        api: PokeApi
    ) = PokemonRepository(api)
}
