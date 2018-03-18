/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.remote

class RemoteRepository(private val webService: WebService) {

    fun getProducts() = webService.getProducts()
}