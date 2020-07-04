package com.easytutor.app.shopping.ui.products

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.easytutor.app.shopping.R
import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.db.CartDao
import com.easytutor.app.shopping.data.db.entity.Cart
import com.easytutor.app.shopping.data.model.ProductX
import com.easytutor.app.shopping.databinding.AdapterProductBinding
import com.easytutor.app.shopping.ui.basket.BasketViewModel
import com.easytutor.app.shopping.ui.basket.BasketViewModelFactory

class ProductAdapter(
    private val product: List<ProductX>,
    val db: AppDatabase,
    private val listner: RecyclerViewClickListner,
    private val getAllData: List<Cart>,
    private val cartData: List<String>
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var cartDao : CartDao
    private lateinit var cart : Cart
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ProductViewHolder (
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.adapter_product,
                    parent,
                    false
                )

            )

    override fun getItemCount() = product.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.recyclerviewProductBinding.productx = product[position]

        cartDao = db.getCartDao()

        if (cartData.contains(product[position].id)) {
            var getPos = cartData.indexOf(product[position].id)
            holder.recyclerviewProductBinding.textQuantity.text = getAllData.get(getPos).quantity
            holder.recyclerviewProductBinding.btnAdd.visibility = GONE
            holder.recyclerviewProductBinding.linQty.visibility = VISIBLE
            holder.recyclerviewProductBinding.textQuantity.text

        }
        holder.recyclerviewProductBinding.btnAdd.setOnClickListener() {
            listner.onRecyclerViewItemClick(
                holder.recyclerviewProductBinding.btnAdd,
                product[position],
                holder.recyclerviewProductBinding.textQuantity.text.toString(),
                holder.recyclerviewProductBinding
            )
        }
        holder.recyclerviewProductBinding.btnPlus.setOnClickListener() {
            listner.onRecyclerViewItemClick(
                holder.recyclerviewProductBinding.btnPlus,
                product[position],
                holder.recyclerviewProductBinding.textQuantity.text.toString(),
                holder.recyclerviewProductBinding
            )
        }
        holder.recyclerviewProductBinding.btnMinus.setOnClickListener() {
            listner.onRecyclerViewItemClick(
                holder.recyclerviewProductBinding.btnMinus,
                product[position],
                holder.recyclerviewProductBinding.textQuantity.text.toString(),
                holder.recyclerviewProductBinding
            )

        }

    }


    inner class ProductViewHolder(
        val recyclerviewProductBinding : AdapterProductBinding) :
        RecyclerView.ViewHolder(recyclerviewProductBinding.root)

}