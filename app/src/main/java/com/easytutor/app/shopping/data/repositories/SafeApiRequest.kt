package com.easytutor.app.shopping.data.repositories

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun<T: Any> apiRequest(call: suspend () -> Response<T>) : T{
        val response = call.invoke()
        if(response.isSuccessful){
            return response.body()!!
        }else{
            //@todo handle api exception
            throw ApiException(response.code().toString())
        }
    }
//    val call: Call<Product> = productApi.getPosts()
//
//    call.enqueue(object : Callback<Product> {
//        override fun onResponse(
//            call: Call<Product>,
//            response: Response<Product>
//        ) {
//            if (!response.isSuccessful()) {
//                textViewResult.text = "Code: " + response.code()
//                return
//            }
//            val posts: Product = response.body()!!
//            for (post in posts.products) {
//                var content = ""
//                content += "ID: " + post.id + "\n"
//                content += "User ID: " + post.name + "\n"
//
//                textViewResult.append(content)
//            }
//        }
//
//
//        override fun onFailure(call: Call<Product>, t: Throwable) {
//            textViewResult.text = t.message
//        }
//    })
}

class ApiException(message: String): IOException(message)