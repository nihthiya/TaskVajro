package com.easytutor.app.shopping.ui.products

import android.view.View
import com.easytutor.app.shopping.data.model.ProductX
import com.easytutor.app.shopping.databinding.AdapterProductBinding

interface RecyclerViewClickListner {

    fun onRecyclerViewItemClick(
        view: View,
        productx: ProductX,
        quantity: String,
        recyclerviewProductBinding: AdapterProductBinding
    )

}