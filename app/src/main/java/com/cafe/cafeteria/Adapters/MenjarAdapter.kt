package com.cafe.cafeteria.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cafe.cafeteria.Models.CardViewModel
import com.cafe.cafeteria.R

class MenjarAdapter(private val data: List<CardViewModel>) : RecyclerView.Adapter<MenjarAdapter.MenjarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenjarViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menjar_card, parent, false)
        return MenjarViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenjarViewHolder, position: Int) {
        val item = data[position]
        holder.nameAndPriceTextView.text = item.nameAndPrice
        holder.imageView.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MenjarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val nameAndPriceTextView: TextView = itemView.findViewById(R.id.nameItemCardView)
    }
}



