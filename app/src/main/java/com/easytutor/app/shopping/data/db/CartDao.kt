package com.easytutor.app.shopping.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.easytutor.app.shopping.data.db.entity.Cart

@Dao
interface CartDao {

    //perform insert operation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cart: Cart)

    @Query("SELECT * FROM Cart")
    fun getCart() : List<Cart>
}