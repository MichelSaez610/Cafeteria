package com.cafe.cafeteria.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafe.cafeteria.Models.MenjarModel
import com.cafe.cafeteria.R

class MenjarAdapter(private val data: List<MenjarModel>, private val onItemClick: (MenjarModel) -> Unit) :
    RecyclerView.Adapter<MenjarAdapter.MenjarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenjarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menjar_card, parent, false)
        return MenjarViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenjarViewHolder, position: Int) {
        val menjar = data[position]
        holder.nameTextView.text = menjar.menjar
        holder.priceTextView.text = "${menjar.preu}€"

        // Set the image here based on your logic
        holder.imageView.setImageResource(R.drawable.food) // Replace with an actual image resource

        // Set up the click listener for the item
        holder.itemView.setOnClickListener {
            onItemClick(menjar)  // Trigger the callback with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MenjarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val nameTextView: TextView = itemView.findViewById(R.id.nameItemCardView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceItemCardView)
    }
}





