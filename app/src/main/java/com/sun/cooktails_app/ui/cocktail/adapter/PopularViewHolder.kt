package com.sun.cooktails_app.ui.cocktail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.utils.LoadImageBitmap
import kotlinx.android.synthetic.main.item_popular.view.*

@Suppress("DEPRECATION")
class PopularViewHolder(itemView: View, private val onItemClick: (Popular) -> Unit) :
    RecyclerView.ViewHolder(itemView) {

    fun itemRow(popular: Popular) {
        itemView.apply {
            textPopularTitle.text = popular.title
            getImage(popular)
            setOnClickListener {
                onItemClick(popular)
            }
        }
    }

    private fun getImage(popular: Popular) {
        LoadImageBitmap(itemView.imagePopular).execute(popular.urlImage)
    }
}
