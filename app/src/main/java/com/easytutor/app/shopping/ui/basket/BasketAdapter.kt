package com.easytutor.app.shopping.ui.basket

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.easytutor.app.shopping.R
import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.db.entity.Cart
import com.easytutor.app.shopping.databinding.AdapterBasketBinding

class BasketAdapter(private val basketdata: List<Cart>,
                    val db: AppDatabase ) :
    RecyclerView.Adapter<BasketAdapter.BasketViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BasketViewHolder (
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.adapter_basket,
                parent,
                false
            )
        )

    override fun getItemCount() = basketdata.size



    override fun onBindViewHolder(holder: BasketViewHolder, position: Int) {
        holder.recyclerviewProductBinding.cart = basketdata[position]
    }

    inner class BasketViewHolder(
        val recyclerviewProductBinding : AdapterBasketBinding
    ) :
        RecyclerView.ViewHolder(recyclerviewProductBinding.root)
}
