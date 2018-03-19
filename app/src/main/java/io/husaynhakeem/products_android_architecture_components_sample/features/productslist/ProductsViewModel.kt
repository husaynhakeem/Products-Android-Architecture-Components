/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.ViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository

class ProductsViewModel(private val repository: ProductsRepository) : ViewModel() {

    private val products = repository.getProducts()

    fun getProducts() = products

    fun refreshProducts() = repository.refreshProducts()
}