/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.ViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository

class ProductsViewModel(private val repository: ProductsRepository) : ViewModel() {

    fun getProducts() = repository.getProducts()

    fun refreshProducts() = repository.refreshProducts()
}