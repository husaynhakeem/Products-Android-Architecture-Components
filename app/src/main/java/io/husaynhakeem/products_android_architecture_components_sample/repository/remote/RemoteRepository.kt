/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product

class RemoteRepository {

    fun getProducts(): LiveData<List<Product>> {
        return MutableLiveData()
    }
}