package com.devdroid.pokedex_mvp.data

interface ListCategoryCallback {

    fun onSuccess(response: List<String>)

    fun onError(message: String)

    fun onComplete()

}