package com.devdroid.pokedex_mvp.data

import retrofit2.Call
import retrofit2.http.GET

interface PokedexApi {

    @GET("type")
    fun findAllTypes() : Call<List<String>>

}