package com.devdroid.pokedex_mvp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devdroid.pokedex_mvp.R
import com.devdroid.pokedex_mvp.data.CategoryRemoteDataSource
import com.devdroid.pokedex_mvp.model.Category
import com.devdroid.pokedex_mvp.model.PokemonType
import com.devdroid.pokedex_mvp.model.PokemonTypeList
import com.devdroid.pokedex_mvp.presentation.HomePresenter
import com.xwray.groupie.GroupieAdapter

class HomeFragment : Fragment() {

    private val adapter = GroupieAdapter()
    lateinit var presenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = HomePresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_main)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        recyclerView.adapter = adapter

        presenter.findAllCategories()

    }

    fun showCategories(response: List<Category>) {

        val categories = response.map { CategoryItem(it) }
        adapter.addAll(categories)
        adapter.notifyDataSetChanged()

    }

}