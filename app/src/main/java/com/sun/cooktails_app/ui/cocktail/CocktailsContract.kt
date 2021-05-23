package com.sun.cooktails_app.ui.cocktail

import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.utils.BasePresenter
import java.lang.Exception

interface CocktailsContract {

    interface View {
        fun onGetCocktailsSuccess(cocktails: MutableList<Popular?>)
        fun onError(exception: Exception?)
    }

    interface Presenter : BasePresenter<View> {
        fun getCocktails()
    }
}
