package com.sun.cooktails_app.ui.cocktail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sun.cooktails_app.R
import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.utils.LoadImageBitmap
import kotlinx.android.synthetic.main.item_popular.view.*


@Suppress("DEPRECATION")
class CocktailsAdapter(private val onItemClick: (Popular) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listPopular = mutableListOf<Popular?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_popular, parent, false)
        return PopularViewHolder(view, onItemClick)
    }

    override fun getItemCount() = listPopular.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PopularViewHolder) {
            listPopular[position]?.let {
                holder.itemRow(it)
            }
        }
    }

    fun setData(newListCocktails: MutableList<Popular?>) {
        newListCocktails.let {
            listPopular.clear()
            listPopular.addAll(it)
            notifyDataSetChanged()
        }
    }

    class PopularViewHolder(itemView: View, private val onItemClick: (Popular) -> Unit) :
        RecyclerView.ViewHolder(itemView) {

        fun itemRow(cocktails: Popular) {
            itemView.apply {
                textPopularTitle.text = cocktails.title
                getImage(cocktails)
                setOnClickListener {
                    onItemClick(cocktails)
                }
            }
        }

        private fun getImage(popular: Popular) {
            LoadImageBitmap(itemView.imagePopular).execute(popular.urlImage)
        }
    }
}
