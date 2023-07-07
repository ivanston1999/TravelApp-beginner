package com.example.travelapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ShowDetailActivity : AppCompatActivity(){

    companion object {
        const val EXTRA_DATA = "data"
        const val EXTRA_LOCATION = "location"
        const val EXTRA_DISTANCE = "distance"
        const val EXTRA_PRICE = "price"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        val actionbar = supportActionBar

        val share = findViewById<Button>(R.id.action_share)
        share.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "https://www.tokopedia.com/blog/objek-wisata-indonesia-yang-terkenal-di-dunia-tvl/?utm_source=google&utm_medium=organic")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }

        val data = intent.getParcelableExtra<Destination>(EXTRA_DATA)
        Log.d("Detail Data", data?.name.toString())

        val location = intent.extra<Destination>(EXTRA_LOCATION)


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}