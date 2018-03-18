/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.model

import android.arch.persistence.room.TypeConverter

class ProductImageListTypeConverter {

    @TypeConverter
    fun fromListToString(list: List<ProductImage>): String {
        var result = ""
        list.forEach { result += "${it.url}," }
        return result.substringBeforeLast(",")
    }

    @TypeConverter
    fun fromStringToList(string: String): List<ProductImage> {
        val result = mutableListOf<ProductImage>()

        if (!string.isBlank()) {
            string.split(",").forEach { result += ProductImage(it) }
        }

        return result
    }
}