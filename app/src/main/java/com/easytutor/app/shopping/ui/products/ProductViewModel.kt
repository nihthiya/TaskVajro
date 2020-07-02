package com.easytutor.app.shopping.ui.products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easytutor.app.shopping.data.model.Product
import com.easytutor.app.shopping.data.repositories.ProductRepository
import com.easytutor.app.shopping.util.Coroutines
import kotlinx.coroutines.Job

class ProductViewModel(val repository: ProductRepository) : ViewModel() {

    private lateinit var job : Job
    private val _products = MutableLiveData<Product>()
    val produts : LiveData<Product>
        //for products we need to use getter
        get() = _products

    fun getProducts() {

        job = Coroutines.ioThenMain(
            {  repository.getProducts()},
            {_products.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()

    }

}
