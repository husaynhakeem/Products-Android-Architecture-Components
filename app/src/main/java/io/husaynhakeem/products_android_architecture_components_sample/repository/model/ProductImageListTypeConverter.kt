/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.model

import android.arch.persistence.room.TypeConverter
import io.husaynhakeem.products_android_architecture_components_sample.utilities.COMMA
import io.husaynhakeem.products_android_architecture_components_sample.utilities.EMPTY

class ProductImageListTypeConverter {

    @TypeConverter
    fun fromListToString(list: List<ProductImage>): String {
        var result = EMPTY
        list.forEach { result += "${it.url}$COMMA" }
        return result.substringBeforeLast(COMMA)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<ProductImage> {
        val result = mutableListOf<ProductImage>()

        if (!string.isBlank()) {
            string.split(COMMA).forEach { result += ProductImage(it) }
        }

        return result
    }
}