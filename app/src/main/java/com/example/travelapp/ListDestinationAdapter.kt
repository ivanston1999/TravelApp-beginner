package com.example.travelapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions



class ListDestinationAdapter(private val listDestination: ArrayList<Destination>): RecyclerView.Adapter<ListDestinationAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback


    fun setOnClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.view_holder, parent,false)
        return ListViewHolder(view)
    }


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, location, price, distance) = listDestination[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvDescription.text = description

        val context = holder.itemView.context

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listDestination[holder.adapterPosition])

            val moveDetail = Intent(context, ShowDetailActivity)
            moveDetail.putExtra(ShowDetailActivity, location)
            moveDetail.putExtra(ShowDetailActivity, price)
            moveDetail.putExtra(ShowDetailActivity, distance)


        }

    }

    override fun getItemCount(): Int = listDestination.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

    interface OnItemClickCallback{
        fun onItemClicked(data: Destination)
    }

}








