package com.example.pokemon.data.datasource.remote

import com.example.pokemon.data.datasource.remote.model.AbilityResponseApiModel
import com.example.pokemon.data.datasource.remote.model.PokemonDetailResponseApiModel
import com.example.pokemon.data.datasource.remote.model.PokemonResponseApiModel
import retrofit2.Response
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
