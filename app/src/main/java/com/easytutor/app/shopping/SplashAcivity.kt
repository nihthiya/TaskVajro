package com.easytutor.app.shopping

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class SplashAcivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_acivity)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 5000)
    }
}
