package com.devdroid.pokedex_mvp.data

import com.devdroid.pokedex_mvp.model.PokemonType
import com.devdroid.pokedex_mvp.model.PokemonTypeList
import retrofit2.*

class CategoryRemoteDataSource {
    fun findAllCategories(callback: ListCategoryCallback) {
        HTTPClient.retrofit()
            .create(PokedexApi::class.java)
            .findAllTypes()
            .enqueue(object : Callback<PokemonTypeList> {
                override fun onResponse(
                    call: Call<PokemonTypeList>,
                    response: Response<PokemonTypeList>
                ) {
                    if (response.isSuccessful) {
                        val categories = response.body()
                        callback.onSuccess(((categories ?: emptyArray<PokemonType>()) as PokemonTypeList))
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Unknown Error")
                    }
                }

                override fun onFailure(call: Call<PokemonTypeList>, t: Throwable) {
                    callback.onError(t.message ?: "Internal Error")
                    callback.onComplete()
                }


            })
    }
}