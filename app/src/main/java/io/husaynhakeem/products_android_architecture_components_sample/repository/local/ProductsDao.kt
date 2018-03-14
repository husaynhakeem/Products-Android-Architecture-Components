/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Query

interface ProductsDao {

    @Query("SELECT * FROM Product")
    fun getAllProducts(): LiveData<Product>
}