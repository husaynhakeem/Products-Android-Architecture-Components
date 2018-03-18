/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.local

import io.husaynhakeem.products_android_architecture_components_sample.repository.model.ProductImage
import io.husaynhakeem.products_android_architecture_components_sample.repository.model.ProductImageListTypeConverter
import org.junit.Assert.assertEquals
import org.junit.Test


class ProductImageListTypeConverterShould {

    private val productImageListTypeConverter = ProductImageListTypeConverter()

    @Test
    fun convertFromListToString() {
        val itemsAsString = productImageListTypeConverter.fromListToString(ITEMS_AS_LIST)
        assertEquals(ITEMS_AS_STRING, itemsAsString)
    }

    @Test
    fun convertFromStringToList() {
        val itemsAsList = productImageListTypeConverter.fromStringToList(ITEMS_AS_STRING)
        assertEquals(ITEMS_AS_LIST, itemsAsList)
    }

    companion object {
        private const val ITEMS_AS_STRING = "url1,url2,url3"
        private val ITEMS_AS_LIST = listOf(
                ProductImage("url1"),
                ProductImage("url2"),
                ProductImage("url3")
        )
    }
}