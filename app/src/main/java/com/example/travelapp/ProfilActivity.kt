package com.example.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout

class ProfilActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val home = findViewById<LinearLayout>(R.id.homeBtn)
        home.setOnClickListener(this)



    }

    override fun onClick(v: View) {
        when(v.id){
        R.id.homeBtn ->{
            val homeIntent = Intent(this@ProfilActivity, MainActivity::class.java)
            startActivity(homeIntent)
        }
        }
    }
}