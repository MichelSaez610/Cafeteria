package com.cafe.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        val binding = FragmentMenjarsBinding.inflate(inflater)

        // Get the entire list of Menjar objects
        val menjarsList = Provider.Menjars

        // Set up the RecyclerView
        val recyclerView = binding.recicleViewMenjar
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Set the adapter with the list of Menjar objects
        val adapter = MenjarAdapter(menjarsList)
        recyclerView.adapter = adapter

        return binding.root
    }
}
