/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.utilities.GET_ALL_PRODUCTS_QUERY

@Dao
interface ProductsDao {

    @Insert(onConflict = REPLACE)
    fun saveProducts(products: Array<Product>)

    @Query(GET_ALL_PRODUCTS_QUERY)
    fun getAllProducts(): LiveData<List<Product>>
}