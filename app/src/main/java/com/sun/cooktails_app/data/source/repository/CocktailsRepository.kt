package com.sun.cooktails_app.data.source.repository

import com.sun.cooktails_app.data.source.remote.OnFetchDataJsonListener
import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.data.source.CocktailDataSource

class CocktailsRepository private constructor(
    private val remote: CocktailDataSource.Remote
) {

    fun getPopular(
        listener: OnFetchDataJsonListener<MutableList<Popular?>>
    ) {
        remote.getPopular(listener)
    }

    companion object {

        private var instance: CocktailsRepository? = null

        fun getInstance(
            remote: CocktailDataSource.Remote
        ): CocktailsRepository {
            return instance ?: synchronized(this) {
                instance ?: CocktailsRepository(remote).also {
                    instance = it
                }
            }
        }
    }
}
