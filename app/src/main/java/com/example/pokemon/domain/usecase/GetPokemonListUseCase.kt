package com.example.pokemon.domain.usecase

import com.example.pokemon.domain.repository.PokemonRepository

class GetPokemonListUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun invoke() = pokemonRepository.getPokemonList()
}