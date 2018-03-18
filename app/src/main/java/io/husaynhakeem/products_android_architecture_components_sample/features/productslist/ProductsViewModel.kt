/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product

class ProductsViewModel(repository: ProductsRepository) : ViewModel() {

    private val products: LiveData<List<Product>> = repository.getProducts()

    fun getProducts(): LiveData<List<Product>> {
        return products
    }
}