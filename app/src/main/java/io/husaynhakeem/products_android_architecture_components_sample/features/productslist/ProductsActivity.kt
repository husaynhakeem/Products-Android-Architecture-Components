/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import io.husaynhakeem.products_android_architecture_components_sample.R
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.utilities.DEVICE_WIDTH_PER_SPAN_COUNT_UNIT
import io.husaynhakeem.products_android_architecture_components_sample.utilities.getDeviceWidthInDP
import kotlinx.android.synthetic.main.activity_products.*
import org.koin.android.architecture.ext.viewModel

class ProductsActivity : AppCompatActivity() {

    private val viewModel by viewModel<ProductsViewModel>()
    private val adapter by lazy { ProductsAdapter() }
    private lateinit var countDownTimer: EmptyProductsMessagesTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setUpProductsList()
        setUpProductsListener()
    }

    private fun setUpProductsList() {
        val spanCount: Int = getDeviceWidthInDP(this) / DEVICE_WIDTH_PER_SPAN_COUNT_UNIT
        if (spanCount < 2)
            productsRecyclerView.layoutManager = LinearLayoutManager(this)
        else
            productsRecyclerView.layoutManager = GridLayoutManager(this, spanCount)
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
        onProductsLoadingStateChanged(ProductsLoadingState.LOADING)
        setUpLoadingMessage()
    }

    private fun setUpLoadingMessage() {
        countDownTimer = EmptyProductsMessagesTimer(this,
                { productsLoadingMessageTextView.text = it },
                {
                    onProductsLoadingStateChanged(ProductsLoadingState.ERROR)
                    productsInternetUnavailableButton.setOnClickListener {
                        viewModel.refreshProducts()
                        onProductsListEmpty()
                    }
                }
        )
        countDownTimer.start()
    }

    private fun displayProducts(products: List<Product>) {
        onProductsLoadingStateChanged(ProductsLoadingState.LOADED)
        adapter.updateProducts(products)
        if (::countDownTimer.isInitialized) countDownTimer.cancel()
    }

    private fun onProductsLoadingStateChanged(state: ProductsLoadingState) {
        when (state) {
            ProductsLoadingState.LOADING -> {
                productsLoadingMessageTextView.visibility = View.VISIBLE
                productsInternetUnavailableContainer.visibility = View.GONE
                productsRecyclerView.visibility = View.GONE
            }
            ProductsLoadingState.ERROR -> {
                productsInternetUnavailableContainer.visibility = View.VISIBLE
                productsLoadingMessageTextView.visibility = View.GONE
                productsRecyclerView.visibility = View.GONE
            }
            ProductsLoadingState.LOADED -> {
                productsRecyclerView.visibility = View.VISIBLE
                productsLoadingMessageTextView.visibility = View.GONE
                productsInternetUnavailableContainer.visibility = View.GONE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::countDownTimer.isInitialized) countDownTimer.cancel()
    }
}