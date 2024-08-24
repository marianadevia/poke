package com.example.pokemon.domain.models

data class PokemonModel(val name: String, val id: Int)

data class PokemonDetailModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val abilities: List<DetailAbility>,
    val imageUrl: String
)

data class DetailAbility(val name: String, val id: Int)

data class AbilityModel(
    val id: Int,
    val name: String,
    val effect: String
)