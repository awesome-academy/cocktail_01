package com.sun.cooktails_app.ui.main

import com.sun.cooktails_app.R
import com.sun.cooktails_app.base.BaseActivity
import com.sun.cooktails_app.ui.homepage.HomePageFragment

class MainActivity : BaseActivity() {

    override fun getLayoutId() = R.layout.activity_main

    override fun onEvent() {}

    override fun onInit() {
        supportFragmentManager.beginTransaction()
            .add(R.id.frameMain, HomePageFragment.newInstance())
            .commit()
    }
}
