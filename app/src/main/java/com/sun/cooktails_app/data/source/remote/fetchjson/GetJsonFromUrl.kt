@file:Suppress("DEPRECATION")

package com.sun.cooktails_app.data.source.remote.fetchjson

import android.os.AsyncTask
import com.sun.cooktails_app.data.source.remote.OnFetchDataJsonListener
import com.sun.cooktails_app.utils.KeyEntityType
import java.lang.Exception

@Suppress("UNCHECKED_CAST", "DEPRECATION")
class GetJsonFromUrl<T>(
    private val keyEntityType: KeyEntityType,
    private val listener: OnFetchDataJsonListener<T>
) : AsyncTask<String?, Void?, String?>() {

    private var exception: Exception? = null

    override fun doInBackground(vararg string: String?): String {
        var data = ""
        try {
            val parseDataWithJson = ParseDataWithJson()
            data = parseDataWithJson.getJsonFromUrl(string[0])
        } catch (e: Exception) {
            exception = e
        }
        return data
    }

    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        if (result != null && result.isNotBlank()) {
            val data = ParseDataWithJson().parseJson(result, keyEntityType)
            data.let {
                listener.onSuccess(it as T)
            }
        } else listener.onError(exception)
    }
}
