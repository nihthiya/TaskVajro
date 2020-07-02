package com.easytutor.app.shopping.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager

import com.easytutor.app.shopping.R
import com.easytutor.app.shopping.data.db.AppDatabase
import com.easytutor.app.shopping.data.db.entity.Cart
import com.easytutor.app.shopping.data.model.ProductX
import com.easytutor.app.shopping.data.network.ProductApi
import com.easytutor.app.shopping.data.repositories.ProductRepository
import com.easytutor.app.shopping.ui.BaseFragment
import com.easytutor.app.shopping.ui.toast
import kotlinx.android.synthetic.main.product_fragment.*
import kotlinx.android.synthetic.main.adapter_product.*
import kotlinx.coroutines.launch

class ProductFragment : BaseFragment(), RecyclerViewClickListner
{
    private lateinit var factory: ProductViewModelFactory
    private lateinit var viewModel: ProductViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.product_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = ProductApi()
        val db = context?.let { AppDatabase(it) }
        val repository = db?.let { ProductRepository(api, it) }

        factory = repository?.let { ProductViewModelFactory(it) }!!
        viewModel = ViewModelProviders.of(this,factory).get(ProductViewModel::class.java)
        viewModel.getProducts()
        viewModel.produts.observe(viewLifecycleOwner, Observer { product ->
            recycler_view_products.also {
                it.layoutManager = GridLayoutManager(requireContext(),2)
                it.setHasFixedSize(true)
                it.adapter = db?.let { it1 -> ProductAdapter(product.products, it1,this) }
            }
        })
        floating_button_add.setOnClickListener(){
//            var intent = Intent(context, BasketActivity::class.java)
//            startActivity(intent)
//            val action = Produc.actionAddNote()
//            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun onRecyclerViewItemClick(view: View, productx: ProductX) {
        when(view.id){
            R.id.btnAdd->    launch {
                var cart = Cart(productx.id,productx.name,productx.price,productx.quantity.toString(),productx.price)
                context?.let {
                    AppDatabase(it).getCartDao().insert(cart)
                    it.toast("Item Added")
                }
            }
            R.id.btnMinus->{
                var count = textQuantity.text.toString().toInt()
                if (count>1){
                    count--
                    textQuantity.text = count.toString()
                }
            }
            R.id.btnPlus->{
                var count = textQuantity.text.toString().toInt()
                count++
                textQuantity.text = count.toString()
            }
        }
    }

}
