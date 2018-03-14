/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.Product

class ProductsViewModel(repository: ProductsRepository) : ViewModel() {

    private var products: MutableLiveData<List<Product>> = MutableLiveData()

    init {
        if (products.value == null || products.value?.size == 0)
            products = repository.getProducts() as MutableLiveData<List<Product>>
    }

    fun getProducts(): MutableLiveData<List<Product>> {
        return products
    }
}