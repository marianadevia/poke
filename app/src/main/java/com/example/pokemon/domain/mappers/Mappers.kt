package com.example.pokemon.domain.mappers

import com.example.pokemon.data.datasource.remote.model.AbilityResponseApiModel
import com.example.pokemon.data.datasource.remote.model.EffectEntry
import com.example.pokemon.data.datasource.remote.model.Pokemon
import com.example.pokemon.data.datasource.remote.model.PokemonDetailResponseApiModel
import com.example.pokemon.domain.models.AbilityModel
import com.example.pokemon.domain.models.DetailAbility
import com.example.pokemon.domain.models.PokemonDetailModel
import com.example.pokemon.domain.models.PokemonModel

fun Pokemon.toDomainModel() = PokemonModel(name, extractPokemonId(url) ?: -1)

fun PokemonDetailResponseApiModel.toDomainDetailModel(): PokemonDetailModel {
    return PokemonDetailModel(
        id,
        name,
        height,
        weight,
        abilities.map { DetailAbility(it.ability.name, extractAbilityId(it.ability.url) ?: -1) },
        sprites.other.officialArtwork.frontDefault
    )
}

// TODO: replace this implementation
private fun extractPokemonId(url: String): Int? {
    val aux: String = url.removePrefix("https://pokeapi.co/api/v2/pokemon/")
    val results: List<String> = aux.split("/")
    return results.firstOrNull()?.toInt()
}

// TODO: replace this implementation
private fun extractAbilityId(url: String): Int? {
    val aux: String = url.removePrefix("https://pokeapi.co/api/v2/ability/")
    val results: List<String> = aux.split("/")
    return results.firstOrNull()?.toInt()
}

fun AbilityResponseApiModel.toAbilityModel(): AbilityModel {
    return AbilityModel(
        id,
        name,
        getEnglishEffect(this.effectEntries)
    )
}

private fun getEnglishEffect(effectEntries: List<EffectEntry>): String {
    val result: EffectEntry? = effectEntries.firstOrNull { it.language.name == "en" }
    return result?.effect ?: ""
}