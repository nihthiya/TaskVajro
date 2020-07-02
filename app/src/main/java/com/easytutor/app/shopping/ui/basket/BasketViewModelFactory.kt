package com.easytutor.app.shopping.ui.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.easytutor.app.shopping.data.repositories.ProductRepository

@Suppress("UNCHECKED_CAST")
class BasketViewModelFactory(private val repository: ProductRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BasketViewModelFactory(repository) as T
    }
}