package com.example.pokemon.domain.usecase

import com.example.pokemon.domain.repository.PokemonRepository

class GetPokemonDetailUseCase(private val pokemonRepository: PokemonRepository) {
    suspend fun invoke(id: Int) = pokemonRepository.getPokemonDetail(id)
}