/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample

import io.husaynhakeem.products_android_architecture_components_sample.features.productslist.ProductsViewModel
import io.husaynhakeem.products_android_architecture_components_sample.repository.BaseRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.BaseRepositoryImpl
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.LocalRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.local.ProductsDatabase
import io.husaynhakeem.products_android_architecture_components_sample.repository.remote.RemoteRepository
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext

val applicationModule = applicationContext {
    bean { ProductsDatabase.instance(androidApplication()).productsDao() }
    bean { BaseRepositoryImpl(get(), get()) as BaseRepository }
    bean { LocalRepository(get()) }
    bean { RemoteRepository() }
}

val productsListModule = applicationContext {
    viewModel { ProductsViewModel(get()) }
}