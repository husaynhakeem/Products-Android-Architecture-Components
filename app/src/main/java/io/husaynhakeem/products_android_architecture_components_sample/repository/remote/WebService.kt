/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.remote

import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import retrofit2.Call
import retrofit2.http.GET


interface WebService {

    @GET("items")
    fun getProducts(): Call<List<Product>>
}