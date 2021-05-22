package com.sun.cooktails_app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Popular(
    val id: String?,
    val title: String?,
    val urlImage: String?
) : Parcelable

object PopularEntry {
    const val DRINKS = "drinks"
    const val ID = "idDrink"
    const val TITLE = "strDrink"
    const val URL_IMAGE = "strDrinkThumb"
}
