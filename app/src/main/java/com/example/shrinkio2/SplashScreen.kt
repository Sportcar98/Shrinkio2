package com.example.shrinkio2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shrinkio2.Login.Register

class SplashScreen : AppCompatActivity() {
    private val SPLASH_TIME_OUT: Long = 3000 //1 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this, Register::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}