package com.sun.cooktails_app.ui.cocktail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.cooktails_app.R
import com.sun.cooktails_app.data.model.Popular


@Suppress("DEPRECATION")
class CocktailsAdapter(private val onItemClick: (Popular) -> Unit) :
    RecyclerView.Adapter<PopularViewHolder>() {

    private var listPopular = mutableListOf<Popular?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular, parent, false)
        return PopularViewHolder(view, onItemClick)
    }

    override fun getItemCount() = listPopular.size

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        listPopular[position]?.let {
            holder.itemRow(it)
        }
    }

    fun setData(newListCocktails: MutableList<Popular?>) {
        newListCocktails.let {
            listPopular.clear()
            listPopular.addAll(it)
            notifyDataSetChanged()
        }
    }
}
