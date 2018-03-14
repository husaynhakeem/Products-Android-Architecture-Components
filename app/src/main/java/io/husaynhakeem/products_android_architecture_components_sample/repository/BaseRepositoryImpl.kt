/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository

import android.arch.lifecycle.LiveData
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.Product
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository

class BaseRepositoryImpl(
        private val localRepository: LocalRepository,
        private val remoteRepository: RemoteRepository) {

    fun getProducts(): LiveData<Product> {
    }
}