package com.cafe.cafeteria

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.cafe.cafeteria.databinding.FragmentHomeBinding

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentHomeBinding.inflate(inflater)

        binding.buttonGoMenjars.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_menjars, null)
        }

        binding.buttonGoBegudes.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_begudes, null)
        }

        binding.buttonGoPostres.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_postres, null)
        }

        binding.buttonGoPagar.setOnClickListener{
            findNavController().navigate(R.id.action_home2_to_total, null)
        }

        return binding.root
    }

}