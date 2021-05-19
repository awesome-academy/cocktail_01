package com.sun.cooktails_app.data.model

data class Cocktails(
        val id: Int,
        val name: String,
        val imageUrl: String
)

object CocktailsEntry {
    const val ID = "idDrink"
    const val NAME = "strDrink"
    const val IMAGE_URL = "strDrinkThumb"
}
