package com.example.pokemon.data.repository

import com.example.pokemon.data.datasource.PokemonRemoteDataSource
import com.example.pokemon.data.datasource.remote.retrofit.DomainError
import com.example.pokemon.data.datasource.remote.retrofit.Either
import com.example.pokemon.data.datasource.remote.retrofit.toDomainError
import com.example.pokemon.domain.mappers.toAbilityModel
import com.example.pokemon.domain.mappers.toDomainDetailModel
import com.example.pokemon.domain.mappers.toDomainModel
import com.example.pokemon.domain.models.AbilityModel
import com.example.pokemon.domain.models.PokemonDetailModel
import com.example.pokemon.domain.models.PokemonModel
import com.example.pokemon.domain.repository.PokemonRepository

class PokemonDataRepository(private val remoteDataSource: PokemonRemoteDataSource
) : PokemonRepository {
    override suspend fun getPokemonList(): Either<DomainError, List<PokemonModel>?> {
        return remoteDataSource.getPokemonList()
            .bimap({ it.toDomainError() }, { it?.map { apiModel -> apiModel.toDomainModel() } })
    }

    override suspend fun getPokemonDetail(id: Int): Either<DomainError, PokemonDetailModel?> {
        return remoteDataSource.getPokemonDetail(id)
            .bimap({ it.toDomainError() }, { it?.toDomainDetailModel() })
    }

    override suspend fun getAbility(id: Int): Either<DomainError, AbilityModel?> {
        return remoteDataSource.getAbility(id)
            .bimap({ it.toDomainError() }, { it?.toAbilityModel() })
    }
}