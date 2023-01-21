package com.devdroid.pokedex_mvp.presentation

import android.graphics.Color
import android.util.Log
import com.devdroid.pokedex_mvp.data.CategoryRemoteDataSource
import com.devdroid.pokedex_mvp.data.ListCategoryCallback
import com.devdroid.pokedex_mvp.model.Category
import com.devdroid.pokedex_mvp.model.PokemonTypeList
import com.devdroid.pokedex_mvp.view.HomeFragment

class HomePresenter(
    val view: HomeFragment,
    val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: PokemonTypeList) {

        val start = 40
        val end = 190
        val diff = (end - start) / response.pokemonTypeList.size

        val categories = response.pokemonTypeList.mapIndexed { index, pokemonType ->

            val hsv = floatArrayOf(
                start + (diff * index).toFloat(),
                100.0f,
                100.0f
            )

            Category(pokemonType.name, Color.HSVToColor(hsv).toLong())

        }

        view.showCategories(categories)
        onComplete()
    }

    override fun onError(message: String) {
        Log.i("moios", message)
        onComplete()
    }

    override fun onComplete() {
        view.hideProgress()
    }
}