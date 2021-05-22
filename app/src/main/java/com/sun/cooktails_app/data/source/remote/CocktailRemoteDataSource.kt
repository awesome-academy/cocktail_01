package com.sun.cooktails_app.data.source.remote

import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.data.source.CocktailDataSource
import com.sun.cooktails_app.data.source.remote.fetchjson.GetJsonFromUrl
import com.sun.cooktails_app.utils.Constant
import com.sun.cooktails_app.utils.KeyEntityType

@Suppress("DEPRECATION")
class CocktailRemoteDataSource : CocktailDataSource.Remote {

    private val baseUrl = Constant.Base_URL + Constant.BASE_POPULAR

    override fun getPopular(
        listener: OnFetchDataJsonListener<MutableList<Popular?>>
    ) {
        GetJsonFromUrl(KeyEntityType.POPULAR, listener).execute(baseUrl)
    }

    companion object {
        private var instance: CocktailRemoteDataSource? = null

        fun getInstance() = instance ?: CocktailRemoteDataSource().also {
            instance = it
        }
    }
}
