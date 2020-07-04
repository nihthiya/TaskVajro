package com.easytutor.app.shopping.ui.basket

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.easytutor.app.shopping.R
import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.repositories.BasketRepository
import kotlinx.android.synthetic.main.basket_fragment.*

class BasketFragment : Fragment() {

    private lateinit var factory: BasketViewModelFactory
    private lateinit var viewModel: BasketViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.basket_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val db = context?.let { AppDatabase(it) }
        val repository = db?.let { BasketRepository(it) }
        factory = repository?.let { BasketViewModelFactory(it) }!!
        viewModel = ViewModelProviders.of(this,factory).get(BasketViewModel::class.java)
        viewModel.getBasketData()

        recycler_view_basket.isNestedScrollingEnabled = false

        viewModel.basketData.observe(viewLifecycleOwner, Observer { basketData ->
            recycler_view_basket.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = db?.let { it1 -> BasketAdapter(basketData, it1) }
            }
        })
    }

}
