package com.example.submission1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.submission1.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    private var Time_Out:Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screnn)
        loadSplashScreen()
    }

    private fun loadSplashScreen(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }, Time_Out)
    }
}