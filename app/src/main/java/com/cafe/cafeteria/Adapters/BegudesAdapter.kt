package com.cafe.cafeteria.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafe.cafeteria.Models.BegudesModel
import com.cafe.cafeteria.R

class BegudesAdapter(private val data: List<BegudesModel>, private val onItemClick: (BegudesModel) -> Unit) :
    RecyclerView.Adapter<BegudesAdapter.BegudaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BegudaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.begudes_card, parent, false)
        return BegudaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BegudaViewHolder, position: Int) {
        val beguda = data[position]
        holder.nameTextView.text = beguda.beguda
        holder.priceTextView.text = "${beguda.preu}€"

        // Set the image here based on your logic
        holder.imageView.setImageResource(R.drawable.drink) // Replace with an actual image resource

        holder.itemView.setOnClickListener {
            onItemClick(beguda)  // Trigger the callback with the clicked item
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class BegudaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val nameTextView: TextView = itemView.findViewById(R.id.nameItemCardView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceItemCardView) // Add this view in your XML
    }
}
