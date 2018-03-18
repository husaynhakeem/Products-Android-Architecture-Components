/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.husaynhakeem.products_android_architecture_components_sample.R
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import kotlinx.android.synthetic.main.activity_products.*
import org.koin.android.architecture.ext.viewModel

class ProductsActivity : AppCompatActivity() {

    private val viewModel by viewModel<ProductsViewModel>()
    private val adapter by lazy { ProductsAdapter() }
    private val countDownTimer by lazy { EmptyProductsMessagesTimer(this, productsEmptyMessageTextView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setUpProductsList()
        setUpProductsListener()
    }

    private fun setUpProductsList() {
        productsRecyclerView.layoutManager = LinearLayoutManager(this)
        productsRecyclerView.adapter = adapter
    }

    private fun setUpProductsListener() {
        viewModel.getProducts().observe(this, Observer {
            if (it == null || it.isEmpty())
                onProductsListEmpty()
            else
                displayProducts(it)
        })
    }

    private fun onProductsListEmpty() {
        productsEmptyMessageTextView.visibility = View.VISIBLE
        countDownTimer.start()
    }

    private fun displayProducts(products: List<Product>) {
        productsEmptyMessageTextView.visibility = View.GONE
        countDownTimer.cancel()
        adapter.updateProducts(products)
    }

    override fun onDestroy() {
        super.onDestroy()
        countDownTimer.cancel()
    }
}