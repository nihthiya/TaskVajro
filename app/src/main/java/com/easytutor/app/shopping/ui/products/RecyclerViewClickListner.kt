package com.easytutor.app.shopping.ui.products

import android.view.View
import com.easytutor.app.shopping.data.model.ProductX

interface RecyclerViewClickListner {

    fun onRecyclerViewItemClick(view : View, productx : ProductX)

}