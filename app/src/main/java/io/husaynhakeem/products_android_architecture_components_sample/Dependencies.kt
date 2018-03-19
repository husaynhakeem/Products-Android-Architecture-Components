/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample

import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.ProductsDatabase
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.WebService
import io.husaynhakeem.products_android_architecture_components_sample.utilities.API_BASE_URL
import io.husaynhakeem.products_android_architecture_components_sample.utilities.ConnectivityAgent
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors


val repositoryModule = applicationContext {
    bean { ProductsRepository(get(), get(), get(), get()) }

    bean { ConnectivityAgent(androidApplication()) }
    bean { Executors.newSingleThreadExecutor() as Executor }

    bean { LocalRepository(get()) }
    bean { ProductsDatabase.instance(androidApplication()).productsDao() }

    bean { RemoteRepository(get()) }
    bean { buildRetrofitInstance().create(WebService::class.java) as WebService }
}

private fun buildRetrofitInstance() = Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
