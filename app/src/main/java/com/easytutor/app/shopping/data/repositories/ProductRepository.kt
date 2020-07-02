package com.easytutor.app.shopping.data.repositories

import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.network.ProductApi

class ProductRepository(
    private val api: ProductApi,
    private var db : AppDatabase) : SafeApiRequest() {

    suspend fun getProducts() = apiRequest { api.getProducts() }


}