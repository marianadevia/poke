package com.example.pokemon.data.datasource.remote

import com.example.pokemon.data.datasource.PokemonRemoteDataSource
import com.example.pokemon.data.datasource.remote.model.AbilityResponseApiModel
import com.example.pokemon.data.datasource.remote.model.Pokemon
import com.example.pokemon.data.datasource.remote.model.PokemonDetailResponseApiModel
import com.example.pokemon.data.datasource.remote.retrofit.Either
import com.example.pokemon.data.datasource.remote.retrofit.RemoteError
import com.example.pokemon.data.datasource.remote.retrofit.executeCall
import kotlinx.coroutines.CoroutineDispatcher

class PokemonRetrofitDataSource(
    private val api: PokemonAPI,
    private val scheduler: CoroutineDispatcher
) : PokemonRemoteDataSource {
    override suspend fun getPokemonList(): Either<RemoteError, List<Pokemon>?> {
        return executeCall(scheduler) { api.getPokemonList() }
            .mapSuccess { it.body()?.results }
    }

    override suspend fun getPokemonDetail(id: Int): Either<RemoteError, PokemonDetailResponseApiModel?> {
        return executeCall(scheduler) { api.getPokemonDetail(id) }
            .mapSuccess { it.body() }
    }

    override suspend fun getAbility(id: Int): Either<RemoteError, AbilityResponseApiModel?> {
        return executeCall(scheduler) { api.getAbilityDetail(id) }
            .mapSuccess { it.body() }
    }
}