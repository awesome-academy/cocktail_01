package com.sun.cooktails_app.ui.cocktail

import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.data.source.remote.OnFetchDataJsonListener
import com.sun.cooktails_app.data.source.repository.CocktailsRepository
import java.lang.Exception

class CocktailsPresenter(private val repository: CocktailsRepository?) :
    CocktailsContact.Presenter {

    private var view: CocktailsContact.View? = null

    override fun getCocktails() {
        repository?.getPopular(
            object : OnFetchDataJsonListener<MutableList<Popular?>> {
                override fun onSuccess(data: MutableList<Popular?>) {
                    view?.onGetCocktailsSuccess(data)
                }

                override fun onError(exception: Exception?) {
                    view?.onError(exception)
                }
            })
    }

    override fun onStart() {
        getCocktails()
    }

    override fun onStop() {
        this.view = null
    }

    override fun setView(view: CocktailsContact.View?) {
        this.view = view
    }
}
