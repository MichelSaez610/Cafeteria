package com.cafe.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cafe.cafeteria.Adapters.TotalAdapter
import com.cafe.cafeteria.databinding.FragmentHomeBinding
import com.cafe.cafeteria.databinding.FragmentTotalBinding

class TotalFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout
        val binding = FragmentTotalBinding.inflate(inflater, container, false)

        // Set up RecyclerView
        val recyclerView = binding.recicleViewTotal
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Observe LiveData for plats, begudes, and postres
        sharedViewModel.plats.observe(viewLifecycleOwner) { plats ->
            sharedViewModel.begudes.observe(viewLifecycleOwner) { begudes ->
                sharedViewModel.postres.observe(viewLifecycleOwner) { postres ->
                    val allItems = plats + begudes + postres // Combine lists

                    val totalAdapter = TotalAdapter(allItems.toMutableList()) { item ->
                        // Remove item logic
                        when {
                            plats.contains(item) -> sharedViewModel.removeItemFromPlats(item.name)
                            begudes.contains(item) -> sharedViewModel.removeItemFromBegudes(item.name)
                            postres.contains(item) -> sharedViewModel.removeItemFromPostres(item.name)
                        }
                        sharedViewModel.updateTotal(-item.price.toDouble())
                    }
                    recyclerView.adapter = totalAdapter
                }
            }
        }

        // Observe total price and update the TextView
        sharedViewModel.totalPrice.observe(viewLifecycleOwner) { total ->
            binding.totalPriceTextView.text = "Total: ${"%.2f".format(total)}€"
        }

        // Handle "Remove All" button click
        binding.button.setOnClickListener {
            sharedViewModel.removeAllItems()
        }

        return binding.root
    }
}

