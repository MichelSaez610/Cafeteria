package com.cafe.cafeteria.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafe.cafeteria.Models.Item
import com.cafe.cafeteria.R

class TotalAdapter(
    private val data: MutableList<Item>,
    private val onRemoveClick: (Item) -> Unit
) : RecyclerView.Adapter<TotalAdapter.TotalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TotalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.total_card, parent, false)
        return TotalViewHolder(view)
    }

    override fun onBindViewHolder(holder: TotalViewHolder, position: Int) {
        val item = data[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = "${item.price}€"
        holder.imageView.setImageResource(item.image)

        // Set up the remove button
        holder.removeButton.setOnClickListener {
            onRemoveClick(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class TotalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val nameTextView: TextView = itemView.findViewById(R.id.nameItemCardView)
        val priceTextView: TextView = itemView.findViewById(R.id.priceItemCardView)
        val removeButton: ImageButton = itemView.findViewById(R.id.removeButton)
    }
}


