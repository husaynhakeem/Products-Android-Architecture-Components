/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository

import android.arch.lifecycle.LiveData
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository
import java.util.concurrent.Executor

class ProductsRepository(
        private val localRepository: LocalRepository,
        private val remoteRepository: RemoteRepository,
        private val executor: Executor) {

    fun getProducts(): LiveData<List<Product>> {
        refreshProducts()
        return localRepository.getProducts()
    }

    private fun refreshProducts() {
        executor.execute {
            val response = remoteRepository.getProducts().execute()
            response.body()?.toTypedArray()?.let {
                localRepository.saveProducts(it)
            }
        }
    }
}