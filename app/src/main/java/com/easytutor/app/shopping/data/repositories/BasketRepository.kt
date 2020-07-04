package com.easytutor.app.shopping.data.repositories

import com.easytutor.app.shopping.data.db.AppDatabase

class BasketRepository(
    private var db : AppDatabase)   {

    suspend fun getBasket() = run { db.getCartDao().getCart() }


}