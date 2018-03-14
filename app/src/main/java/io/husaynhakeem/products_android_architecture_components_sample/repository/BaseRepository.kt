/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository

import android.arch.lifecycle.LiveData
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.Product

interface BaseRepository {

    fun getProducts(): LiveData<Product>
}