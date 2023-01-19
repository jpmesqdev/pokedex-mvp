package com.devdroid.pokedex_mvp.data

import com.devdroid.pokedex_mvp.model.PokemonTypeList
import retrofit2.Call
import retrofit2.http.GET

interface PokedexApi {

    @GET("type/")
    fun findAllTypes() : Call<PokemonTypeList>

}