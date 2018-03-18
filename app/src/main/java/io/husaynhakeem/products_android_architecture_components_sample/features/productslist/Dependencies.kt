/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.features.productslist

import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext


val productsListModule = applicationContext {
    viewModel { ProductsViewModel(get()) }
}