package com.dicoding.githubusersub2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.dicoding.githubusersub2.activity.GithubUserActivity
import com.dicoding.githubusersub2.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        Time Splash Screen

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashScreen, GithubUserActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}