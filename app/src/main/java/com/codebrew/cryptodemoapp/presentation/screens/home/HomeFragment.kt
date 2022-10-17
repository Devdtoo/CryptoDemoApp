package com.codebrew.cryptodemoapp.presentation.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.codebrew.cryptodemoapp.R
import com.codebrew.cryptodemoapp.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            emptyBtn.setOnClickListener {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToEmptyStateFragment())
            }
            valueBtn.setOnClickListener {
                navigateToFragment(HomeFragmentDirections.actionHomeFragmentToValueStateFragment())
            }
        }

    }

    private fun navigateToFragment(navDirection: NavDirections) {
        requireView().findNavController().navigate(navDirection)
    }


}