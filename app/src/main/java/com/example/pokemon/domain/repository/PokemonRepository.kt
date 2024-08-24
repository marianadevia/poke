package com.example.pokemon.domain.repository

import com.example.pokemon.data.datasource.remote.retrofit.DomainError
import com.example.pokemon.data.datasource.remote.retrofit.Either
import com.example.pokemon.domain.models.AbilityModel
import com.example.pokemon.domain.models.PokemonDetailModel
import com.example.pokemon.domain.models.PokemonModel

interface PokemonRepository {
    suspend fun getPokemonList(): Either<DomainError, List<PokemonModel>?>
    suspend fun getPokemonDetail(id: Int): Either<DomainError, PokemonDetailModel?>
    suspend fun getAbility(id: Int): Either<DomainError, AbilityModel?>
}