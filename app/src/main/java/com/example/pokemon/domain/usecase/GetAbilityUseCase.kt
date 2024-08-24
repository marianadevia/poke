package com.example.pokemon.domain.usecase

import com.example.pokemon.domain.repository.PokemonRepository


class GetAbilityUseCase(private val pokemonRepository: PokemonRepository) {
    suspend operator fun invoke(id: Int) = pokemonRepository.getAbility(id)
}