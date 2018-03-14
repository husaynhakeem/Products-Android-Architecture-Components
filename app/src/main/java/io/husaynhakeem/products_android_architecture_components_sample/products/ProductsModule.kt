/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.products

import io.husaynhakeem.products_android_architecture_components_sample.repository.BaseRepository
import io.husaynhakeem.products_android_architecture_components_sample.repository.BaseRepositoryImpl
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val productsModule = applicationContext {
    viewModel { ProductsViewModel(get()) }
    bean { BaseRepositoryImpl() as BaseRepository }
}