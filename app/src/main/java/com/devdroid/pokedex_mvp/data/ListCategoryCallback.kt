package com.devdroid.pokedex_mvp.data

import com.devdroid.pokedex_mvp.model.PokemonTypeList

interface ListCategoryCallback {

    fun onSuccess(response: PokemonTypeList)

    fun onError(message: String)

    fun onComplete()

}