package com.devdroid.pokedex_mvp.data

import retrofit2.*

class CategoryRemoteDataSource {
    fun findAllCategories(callback: ListCategoryCallback) {
        HTTPClient.retrofit()
            .create(PokedexApi::class.java)
            .findAllTypes()
            .enqueue(object : Callback<List<String>> {
                override fun onResponse(
                    call: Call<List<String>>,
                    response: Response<List<String>>
                ) {
                    if (response.isSuccessful) {
                        val categories = response.body()
                        callback.onSuccess(categories ?: emptyList())
                    } else {
                        val error = response.errorBody()?.string()
                        callback.onError(error ?: "Unknown Error")
                    }
                }

                override fun onFailure(call: Call<List<String>>, t: Throwable) {
                    callback.onError(t.message ?: "Internal Error")
                    callback.onComplete()
                }

            })
    }
}