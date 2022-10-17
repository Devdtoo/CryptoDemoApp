package com.codebrew.cryptodemoapp.presentation.screens.empty_state_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codebrew.cryptodemoapp.presentation.screens.empty_state_detail.viewmodel.CryptoEmptyViewModel
import com.codebrew.cryptodemoapp.R
import com.codebrew.cryptodemoapp.common.Result
import com.codebrew.cryptodemoapp.databinding.FragmentEmptyStateBinding
import com.codebrew.cryptodemoapp.presentation.screens.adapters.CryptoHoldingsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmptyStateFragment : Fragment() {
    lateinit var binding: FragmentEmptyStateBinding
    lateinit var cryptoHoldingAdapter: CryptoHoldingsAdapter
    private val viewModel by hiltNavGraphViewModels<CryptoEmptyViewModel>(R.id.nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_empty_state, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        viewModel.getEmptyStateData()
        viewModel.state.observe(viewLifecycleOwner) {
            when(it) {
                is Result.Success -> {
                    it.data?.your_crypto_holdings?.let { holdingsDataList ->
                        cryptoHoldingAdapter.setData(holdingsDataList)
                    }

                }
                is Result.Loading -> {

                }
                is Result.Error -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun setupRecyclerView() {
        val recyclerViewNews = binding.cryptoHildingRv
        cryptoHoldingAdapter = CryptoHoldingsAdapter()
        recyclerViewNews.adapter = cryptoHoldingAdapter
        recyclerViewNews.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewNews.setHasFixedSize(true)
    }


}