package com.sun.cooktails_app.data.source.remote.fetchjson

import com.sun.cooktails_app.data.model.PopularEntry
import com.sun.cooktails_app.utils.KeyEntityType
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

@Suppress("NAME_SHADOWING")
class ParseDataWithJson {

    fun getJsonFromUrl(urlString: String?): String {
        val url = URL(urlString)
        val httpURLConnection = url.openConnection() as HttpURLConnection
        httpURLConnection.apply {
            connectTimeout = TIME_OUT
            readTimeout = TIME_OUT
            requestMethod = METHOD_GET
            doOutput = true
            connect()
        }

        val bufferedReader = BufferedReader(InputStreamReader(url.openStream()))
        val stringBuffer = StringBuffer()
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            stringBuffer.append(line)
        }
        bufferedReader.close()
        httpURLConnection.disconnect()
        return stringBuffer.toString()
    }

    private fun parseJsonToData(jsonArray: JSONArray, keyEntityType: KeyEntityType): Any {
        val data = mutableListOf<Any>()
        try {
            for (i in 0 until jsonArray.length()) {
                val jsonObjects = jsonArray.getJSONObject(i)
                val item = ParseDataWithJson().parseJsonToObject(jsonObjects, keyEntityType)
                item?.let { data.add(it) }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return data
    }

    private fun parseJsonToObject(jsonObject: JSONObject, keyEntityType: KeyEntityType): Any? {
        val parseJson = ParseJson()
        return when (keyEntityType) {
            KeyEntityType.POPULAR -> {
                parseJson.parseJsonToCocktail(jsonObject = jsonObject)
            }
        }
    }

    fun parseJson(jsonString: String, keyEntityType: KeyEntityType): Any? =
        try {
            when (keyEntityType) {
                KeyEntityType.POPULAR -> {
                    parseJsonToData(
                        jsonArray = JSONObject(jsonString).getJSONArray(PopularEntry.DRINKS),
                        keyEntityType
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }

    companion object {
        private const val TIME_OUT = 15000
        private const val METHOD_GET = "GET"
    }
}
