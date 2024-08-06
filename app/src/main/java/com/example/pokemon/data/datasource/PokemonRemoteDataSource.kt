package com.example.pokemon.data.datasource

import com.example.pokemon.data.datasource.remote.model.AbilityResponseApiModel
import com.example.pokemon.data.datasource.remote.model.Pokemon
import com.example.pokemon.data.datasource.remote.model.PokemonDetailResponseApiModel
import com.example.pokemon.data.datasource.remote.retrofit.Either
import com.example.pokemon.data.datasource.remote.retrofit.RemoteError

interface PokemonRemoteDataSource {
    suspend fun getPokemonList(): Either<RemoteError, List<Pokemon>?>
    suspend fun getPokemonDetail(id: Int): Either<RemoteError, PokemonDetailResponseApiModel?>
    suspend fun getAbility(id: Int): Either<RemoteError, AbilityResponseApiModel?>
}