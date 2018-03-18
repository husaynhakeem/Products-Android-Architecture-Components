/*
 * Copyright (c) 2018 HusaynHakeem.
 */

package io.husaynhakeem.products_android_architecture_components_sample.repository.model

import android.arch.persistence.room.TypeConverter
import io.husaynhakeem.products_android_architecture_components_sample.utilities.random

class ProductImageListTypeConverter {

    @TypeConverter
    fun fromListToString(list: List<ProductImage>): String {
        var result = ""
        list.forEach { result += "${(0..Int.MAX_VALUE).random()},${it.url}," }
        return result.substringBeforeLast(",")
    }

    @TypeConverter
    fun fromStringToList(string: String): List<ProductImage> {
        val result = mutableListOf<ProductImage>()

        if (!string.isBlank()) {
            val idsAndUrls = string.split(",")
            for (i in 0 until idsAndUrls.size step 2) {
                val id = idsAndUrls[i].toInt()
                val url = idsAndUrls[i + 1]
                result += ProductImage(id, url)
            }
        }

        return result
    }
}