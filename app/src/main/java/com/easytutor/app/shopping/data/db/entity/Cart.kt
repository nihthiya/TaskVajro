package com.easytutor.app.shopping.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Cart (

    @PrimaryKey
    var id : String,

    @ColumnInfo(name = "title")
    var title : String? = null,

    @ColumnInfo(name = "price")
    var price : String? = null,

    @ColumnInfo(name = "quantity")
    var quantity : String? = null,

    @ColumnInfo(name = "image")
    var image : String? = null
){

}