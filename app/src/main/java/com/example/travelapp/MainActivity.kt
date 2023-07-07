package com.example.travelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var rvDestinations: RecyclerView
    private val list = ArrayList<Destination>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestinations = findViewById(R.id.rvDestination)
        rvDestinations.setHasFixedSize(true)

        list.addAll(getListDestinations())
        showRecyclerList()

        val about = findViewById<LinearLayout>(R.id.about_page)
        about.setOnClickListener(this)

    }

    private fun getListDestinations(): ArrayList<Destination> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataDistance = resources.getStringArray(R.array.data_distance)

        val listDestination = ArrayList<Destination>()
        for (i in dataName.indices) {
            val destination = Destination(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataLocation[i], dataPrice[i], dataDistance[i])
            listDestination.add(destination)
        }
        return listDestination
    }

    private fun showRecyclerList() {
        rvDestinations.layoutManager = LinearLayoutManager(this)
        val listDestinationAdapter = ListDestinationAdapter(list)
        rvDestinations.adapter = listDestinationAdapter

        listDestinationAdapter.setOnClickCallback(object : ListDestinationAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Destination) {
                val intentToDetail = Intent(this@MainActivity, ShowDetailActivity::class.java)
                intentToDetail.putParcelableArrayListExtra("DATA", list)
                startActivity(intentToDetail)
            }
        })
    }


    override fun onClick(v: View) {
        when (v.id){
            R.id.about_page ->{
                val profileIntent = Intent(this@MainActivity, ProfilActivity::class.java)
                startActivity(profileIntent)
            }
        }
    }
}


