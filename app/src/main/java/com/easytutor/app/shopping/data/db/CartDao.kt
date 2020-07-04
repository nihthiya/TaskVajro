package com.easytutor.app.shopping.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.easytutor.app.shopping.data.db.entity.Cart

@Dao
interface CartDao {

    //perform insert operation
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cart: Cart)

    @Query("SELECT * FROM Cart")
    suspend fun getCart() : List<Cart>

    @Query("SELECT id  FROM Cart")
    suspend fun getAllId() : List<String>

    @Query("DELETE FROM Cart WHERE id = :id")
    suspend fun delete(id : String)

    @Update
    suspend fun updateQuantity(cart: Cart)
}