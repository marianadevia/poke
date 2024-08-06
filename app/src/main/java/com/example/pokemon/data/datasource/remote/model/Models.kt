package com.example.pokemon.data.datasource.remote.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class PokemonResponseApiModel(
    @SerializedName("results") val results: List<Pokemon>?
)

data class PokemonDetailResponseApiModel(
    @SerializedName("abilities") val abilities: List<Ability>,
    @SerializedName("height") val height: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("weight") val weight: Int,
    @SerializedName("sprites") val sprites: Sprites
)

data class Ability(
    @SerializedName("ability") val ability: AbilityX
)

data class AbilityX(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class AbilityResponseApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("effect_entries") val effectEntries: List<EffectEntry>
)

data class EffectEntry(
    @SerializedName("effect") val effect: String,
    @SerializedName("short_effect") val shortEffect: String,
    @SerializedName("language") val language: Lan
)

data class Lan(
    @SerializedName("name") val name: String
)

data class Sprites(
    @SerializedName("other") val other: Other
)

data class Other(
    @SerializedName("official-artwork") val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @SerializedName("front_default") val frontDefault: String
)