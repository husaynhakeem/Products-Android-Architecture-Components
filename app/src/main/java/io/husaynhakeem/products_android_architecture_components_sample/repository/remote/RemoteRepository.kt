/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.remote

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteRepository(private val webService: WebService) {

    fun getProducts(): LiveData<List<Product>> {
        val products = MutableLiveData<List<Product>>()
        webService.getProducts().enqueue(object : Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>?) {
                Log.d(TAG, "${response?.body()}")
                products.value = response?.body()
            }

            override fun onFailure(call: Call<List<Product>>?, t: Throwable?) {
                Log.e(TAG, "RemoteRepository.getProducts(): Error white getting products from the webService -> $t")
            }
        })
        return products
    }

    companion object {
        private const val TAG = "RemoteRepository"
    }
}