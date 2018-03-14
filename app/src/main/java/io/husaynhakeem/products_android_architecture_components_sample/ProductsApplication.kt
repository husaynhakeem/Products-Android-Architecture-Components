/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample

import android.app.Application
import io.husaynhakeem.products_android_architecture_components_sample.products.productsModule
import org.koin.android.ext.android.startKoin

class ProductsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(productsModule))
    }
}