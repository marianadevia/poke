package com.example.pokemon.di

import com.example.pokemon.data.datasource.PokemonRemoteDataSource
import com.example.pokemon.data.repository.PokemonDataRepository
import com.example.pokemon.domain.repository.PokemonRepository
import com.example.pokemon.domain.usecase.GetAbilityUseCase
import com.example.pokemon.domain.usecase.GetPokemonDetailUseCase
import com.example.pokemon.domain.usecase.GetPokemonListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PokemonDomainModule {
    @Provides
    @Singleton
    fun provideGetPokemonListUseCase(repository: PokemonRepository) =
        GetPokemonListUseCase(repository)

    @Provides
    @Singleton
    fun provideGetPokemonDetailUseCase(repository: PokemonRepository) =
        GetPokemonDetailUseCase(repository)

    @Provides
    @Singleton
    fun provideGetAbilityUseCase(repository: PokemonRepository) = GetAbilityUseCase(repository)

    @Provides
    @Singleton
    fun providePokemonRepository(
        remoteDataSource: PokemonRemoteDataSource
    ): PokemonRepository {
        return PokemonDataRepository(remoteDataSource)
    }
}