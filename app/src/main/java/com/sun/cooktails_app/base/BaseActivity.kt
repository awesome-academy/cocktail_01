package com.sun.cooktails_app.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        onInit()
        onEvent()
    }

    abstract val layoutResourceId: Int

    abstract fun onInit()

    abstract fun onEvent()
}
