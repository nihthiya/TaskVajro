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
import com.easytutor.app.shopping.data.model.ProductX
import com.easytutor.app.shopping.databinding.AdapterProductBinding

class ProductAdapter(
    private val product: List<ProductX>,
    val db: AppDatabase,
    private val listner: RecyclerViewClickListner
) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private lateinit var cartDao : CartDao
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
        holder.recyclerviewProductBinding.btnAdd.setOnClickListener(){
            holder.recyclerviewProductBinding.btnAdd.visibility = GONE
            holder.recyclerviewProductBinding.linQty.visibility = VISIBLE

            listner.onRecyclerViewItemClick(holder.recyclerviewProductBinding.btnAdd,product[position])
        }
        holder.recyclerviewProductBinding.btnPlus.setOnClickListener(){
//            listner.onRecyclerViewItemClick(holder.recyclerviewProductBinding.btnPlus,product[position])
            var count = holder.recyclerviewProductBinding.textQuantity.text.toString().toInt()
            count++
            holder.recyclerviewProductBinding.textQuantity.text = count.toString()
        }
        holder.recyclerviewProductBinding.btnMinus.setOnClickListener(){
//            listner.onRecyclerViewItemClick(holder.recyclerviewProductBinding.btnMinus,product[position])
            var count = holder.recyclerviewProductBinding.textQuantity.text.toString().toInt()
            if (count>1){
                count--
                holder.recyclerviewProductBinding.textQuantity.text = count.toString()
            }
        }

    }


    inner class ProductViewHolder(
        val recyclerviewProductBinding : AdapterProductBinding) :
        RecyclerView.ViewHolder(recyclerviewProductBinding.root)

}