package com.sun.cooktails_app.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cocktails(
    val id: Int?,
    val name: String?,
    val imageUrl: String?
): Parcelable

object CocktailsEntry {
    const val ID = "idDrink"
    const val NAME = "strDrink"
    const val IMAGE_URL = "strDrinkThumb"
}
