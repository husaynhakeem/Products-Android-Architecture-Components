/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.Product
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.ProductImageListTypeConverter

@Database(entities = [(Product::class)], version = 1, exportSchema = false)
@TypeConverters(ProductImageListTypeConverter::class)
abstract class ProductsDatabase : RoomDatabase() {

    abstract fun productsDao(): ProductsDao

    companion object {
        private var INSTANCE: ProductsDatabase? = null
        fun instance(context: Context): ProductsDatabase {
            synchronized(ProductsDatabase::class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                            ProductsDatabase::class.java,
                            "products.db")
                            .build()
                }
                return INSTANCE!!
            }
        }
    }
}