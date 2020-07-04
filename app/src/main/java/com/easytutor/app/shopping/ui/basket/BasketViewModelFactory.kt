package com.easytutor.app.shopping.ui.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.easytutor.app.shopping.data.repositories.BasketRepository


@Suppress("UNCHECKED_CAST")
class BasketViewModelFactory (private val repository: BasketRepository)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BasketViewModel(repository) as T
    }
}