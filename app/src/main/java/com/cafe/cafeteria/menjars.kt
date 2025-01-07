package com.cafe.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafe.cafeteria.Adapters.MenjarAdapter
import com.cafe.cafeteria.databinding.FragmentMenjarsBinding

class Menjars : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMenjarsBinding.inflate(inflater, container, false)

        // Access Menjars directly
        val menjars = Provider.Menjars

        // Set up the RecyclerView
        val recyclerView = binding.recicleViewMenjar
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Set the adapter with the list of Menjars
        val adapter = MenjarAdapter(menjars) { clickedItem ->
            // Handle the clicked item here
            // For example, you can show a Toast, navigate, or update UI with the clicked item
            Toast.makeText(context, "${clickedItem.menjar} afegit al carret", Toast.LENGTH_SHORT).show()
            sharedViewModel.addItemToMenjars(clickedItem.menjar, 1, clickedItem.preu, R.drawable.food)
            sharedViewModel.updateTotal(clickedItem.preu.toDouble())
        }
        recyclerView.adapter = adapter

        return binding.root
    }
}


