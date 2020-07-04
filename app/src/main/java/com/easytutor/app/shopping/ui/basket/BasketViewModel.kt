package com.easytutor.app.shopping.ui.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.db.entity.Cart
import com.easytutor.app.shopping.data.repositories.BasketRepository
import com.easytutor.app.shopping.data.repositories.ProductRepository
import com.easytutor.app.shopping.util.Coroutines
import kotlinx.coroutines.Job

class BasketViewModel(val repository: BasketRepository) : ViewModel() {
    private lateinit var job : Job
    private val _basketData = MutableLiveData<List<Cart>>()
    val basketData : LiveData<List<Cart>>
        //for products we need to use getter
        get() = _basketData

    fun getBasketData() {

        job = Coroutines.ioThenMain(
            {  repository.getBasket()},
            {_basketData.value = it}
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()

    }
}
