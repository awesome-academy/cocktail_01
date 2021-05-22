package com.sun.cooktails_app.data.source

import com.sun.cooktails_app.data.source.remote.OnFetchDataJsonListener
import com.sun.cooktails_app.data.model.Popular

interface CocktailDataSource {

    interface Remote {
        fun getPopular(
            listener: OnFetchDataJsonListener<MutableList<Popular?>>
        )
    }
}
