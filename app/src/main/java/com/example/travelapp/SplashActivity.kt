package com.example.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout

class SplashActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val handler = Handler()
        handler.postDelayed({

            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    }



