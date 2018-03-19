/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.remote

import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.utilities.PATH_ALL_PRODUCTS
import retrofit2.Call
import retrofit2.http.GET


interface WebService {

    @GET(PATH_ALL_PRODUCTS)
    fun getProducts(): Call<List<Product>>
}