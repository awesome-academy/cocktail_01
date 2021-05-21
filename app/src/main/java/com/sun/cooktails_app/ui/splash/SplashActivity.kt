package com.sun.cooktails_app.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.sun.cooktails_app.R
import com.sun.cooktails_app.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(getSplashIntent(this))
        }, 2000)
    }

    private fun getSplashIntent(context: Context) = Intent(context, MainActivity::class.java)
}
