package com.devdroid.pokedex_mvp.model

import com.google.gson.annotations.SerializedName

data class PokemonTypeList(@SerializedName("results") val pokemonTypeList: List<PokemonType>)

