package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.Amiibo
import kotlin.coroutines.coroutineContext

class CustomAdapter(private val dataset:ArrayList<Amiibo>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var textView: TextView =  view.findViewById(R.id.textView)
        var textView2:TextView = view.findViewById(R.id.textView2)
        var imageView: ImageView = view.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        var amiibo = dataset[position]
        holder.textView.text = amiibo.character
        holder.textView2.text = amiibo.amiiboSeries
        Glide.with(holder.imageView).load(amiibo.image).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}