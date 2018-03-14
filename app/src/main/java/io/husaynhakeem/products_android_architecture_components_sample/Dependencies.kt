/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample

import io.husaynhakeem.products_android_architecture_components_sample.features.productslist.ProductsViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.ProductsRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.ProductsDatabase
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import java.util.concurrent.Executor
import java.util.concurrent.Executors

val applicationModule = applicationContext {
    bean { ProductsRepository(get(), get(), get()) }
    bean { LocalRepository(get()) }
    bean { RemoteRepository() }
    bean { Executors.newSingleThreadExecutor() as Executor }
    bean { ProductsDatabase.instance(androidApplication()).productsDao() }
}

val productsListModule = applicationContext {
    viewModel { ProductsViewModel(get()) }
}