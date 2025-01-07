package com.cafe.cafeteria.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafe.cafeteria.Models.PostresModel
import com.cafe.cafeteria.R

class PostresAdapter (private val data: List<PostresModel>, private val onItemClick: (PostresModel) -> Unit) :
    RecyclerView.Adapter<PostresAdapter.PostresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostresViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menjar_card, parent, false)
        return PostresViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostresViewHolder, position: Int) {
        val postres = data[position]
        holder.nameTextView.text = postres.postre
        holder.priceTextView.text = "${postres.preu}€"

        // Set the image here based on your logic
        holder.imageView.setImageResource(R.drawable.dessert) // Replace with an actual image resource

        holder.itemView.setOnClickListener {
            onItemClick(postres)  // Trigger the callback with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class PostresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val nameTextView: TextView = itemView.findViewById(R.id.nameItemCardView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceItemCardView) // Add this view in your XML
    }
}