package com.example.pokemon.data.datasource.remote

import com.example.pokemon.data.datasource.remote.model.AbilityResponseApiModel
import com.example.pokemon.data.datasource.remote.model.PokemonDetailResponseApiModel
import com.example.pokemon.data.datasource.remote.model.PokemonResponseApiModel
import com.google.gson.GsonBuilder
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {
    @GET("pokemon")
    suspend fun getPokemonList(): Response<PokemonResponseApiModel>

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): Response<PokemonDetailResponseApiModel>

    @GET("ability/{id}")
    suspend fun getAbilityDetail(@Path("id") id: Int): Response<AbilityResponseApiModel>
}


object RetrofitClient {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}