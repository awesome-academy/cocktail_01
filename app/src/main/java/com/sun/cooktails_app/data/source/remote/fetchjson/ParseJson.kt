package com.sun.cooktails_app.data.source.remote.fetchjson

import com.sun.cooktails_app.data.model.Popular
import com.sun.cooktails_app.data.model.PopularEntry
import org.json.JSONObject

class ParseJson {

    fun parseJsonToCocktail(jsonObject: JSONObject?) = jsonObject?.run {
        Popular(
            id = getString(PopularEntry.ID),
            title = getString(PopularEntry.TITLE),
            urlImage = getString(PopularEntry.URL_IMAGE),
        )
    }
}
