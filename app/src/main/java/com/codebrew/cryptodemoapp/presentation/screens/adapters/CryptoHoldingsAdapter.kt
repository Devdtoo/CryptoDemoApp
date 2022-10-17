package com.codebrew.cryptodemoapp.presentation.screens.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codebrew.cryptodemoapp.data.model.response.YourCryptoHolding
import com.codebrew.cryptodemoapp.databinding.CryptoHoldingItemBinding
import com.codebrew.cryptodemoapp.presentation.screens.adapters.CryptoHoldingsAdapter.*

class CryptoHoldingsAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    lateinit var binding: CryptoHoldingItemBinding
    private var cryptoHoldingList: List<YourCryptoHolding> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CryptoHoldingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(cryptoHoldingList[position])

    }

    override fun getItemCount() = cryptoHoldingList.size -1

    fun setData(list: List<YourCryptoHolding>){
        cryptoHoldingList = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(binding: CryptoHoldingItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(holdingData: YourCryptoHolding) {
            binding.TitleTv.text = holdingData.title
            Glide
                .with(binding.root.context)
                .load(holdingData.logo)
                .centerCrop()
                .into(binding.logoIv)
        }
    }
}