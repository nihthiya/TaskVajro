package com.easytutor.app.shopping.ui.basket

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easytutor.app.shopping.data.db.entity.Cart
import com.easytutor.app.shopping.data.repositories.ProductRepository
import kotlinx.coroutines.Job

class BasketViewModel(val repository: ProductRepository) : ViewModel() {
    private lateinit var job : Job
    private val _basketData = MutableLiveData<List<Cart>>()
    val basketData : MutableLiveData<List<Cart>>
        //for products we need to use getter
        get() = _basketData

    fun getBasketData() {

//        job = Coroutines.ioThenMain(
//            {  repository.getBasketData()},
//            {_basketData.value = it}
//        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()

    }
}
