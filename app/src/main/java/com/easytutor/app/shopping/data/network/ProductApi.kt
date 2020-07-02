package com.easytutor.app.shopping.data.network

import com.easytutor.app.shopping.data.model.Product
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ProductApi {
    @GET("5def7b172f000063008e0aa2")
    suspend fun getProducts(): Response<Product>

    companion object{
        operator fun invoke() : ProductApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.mocky.io/v2/")
                .build()
                .create(ProductApi::class.java)
        }
    }
}